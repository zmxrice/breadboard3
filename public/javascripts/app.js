var root = angular.module('root',['ngAnimate','ui.bootstrap', 'textAngular'])
//parameter adding and editing
root.controller('ngSelect', function($scope) {
	$scope.optionsData =
  [{
     val : "Integer",
		 title : "Integer"
   },
   {
		 val : "Decimal",
  	 title : "Decimal"
   },
   {
	 	 val : "Text",
		 title : "Text"
	 },
   {
		 val : "Boolean",
		 title : "Boolean"
	 }];
});

root.service('Experiment', function(){
	this.experiment_id;
	this.setExpId = function(exp_id){
		this.experiment_id = exp_id;
	}
});

root.controller('paramController', function($scope, $http) {
	$scope.items = []
	$scope.getExpParams = function(){
		if($scope.expid != null && $scope.expid != undefined && $scope.expid != ""){
			var httpRequest = $http({
				method: 'GET',
				url: "/paramlist/" + $scope.expid
			}).success(function(data, status){
				$scope.items = data;
			}).error(function(arg){
				console.log("error");
			});
		}
		else{
			$scope.items = [];
		}
	}

	$scope.$watch('expid', $scope.getExpParams);

	$scope.addParam = function(addItem){
		addItem.experiment_id = $scope.expid;
		addItem.id = 0;//dummy id
		console.log(JSON.stringify(addItem));
		var req = $http({
			method:'POST',
			url:'/addparam',
			data:addItem
		}).success(function(data, status){
			console.log(data);
			//reset the form
			$scope.addItem.name="";
			$scope.addItem.val_type="";
			$scope.addItem.min_val="";
			$scope.addItem.max_val="";
			$scope.addItem.default_val="";
			$scope.addItem.description="";
			//re-get the list
			$scope.getExpParams($scope.expid);
		}).error(function(data, status){
			console.log(data);
		});
	}

	$scope.updateParam = function(item){
		console.log(JSON.stringify(item));
		var req = $http({
			method:'PUT',
			url:'/updateparam',
			data:item
		}).success(function(data, status){
			console.log(data);
			$scope.getExpParams($scope.expid);
		}).error(function(arg){
			console.log("error");
		});
	}

	$scope.removeParam = function(item){
		console.log(JSON.stringify(item));
		var req = $http({
			method:'POST',
			url:'/deleteparam',
			data:item
		}).success(function(data, status){
			console.log(data);
			$scope.getExpParams($scope.expid);
		}).error(function(arg){
			console.log("error");
		});
	}

});


//dialog controller and adding experiment controller
root.controller('expController', ['$scope','$http','Experiment', function($scope, $http, Experiment){
	$scope.experiment_id = Experiment.experiment_id;
	$scope.setExpId = Experiment.setExpId;
	$scope.expOptions = []
	$http({
			method: 'GET',
			url: "/explist"
		}).success(function(data, status){
			$scope.expOptions = data;
		}).error(function(arg){
			alert("error");
		});


//dialogs part
  $scope.dialogs = [
    {
      minimized: false,
      maximized: false,
      width: 1000,
      height: 300,
      top: 10,
      left: 10,
      zindex: 3,
      template: 'assets/dialog/parameter.html'
    },

    {
      minimized: false,
      maximized: false,
      width: 900,
      height: 450,
      top: 100,
      left: 500,
      zindex: 4,
      template: 'assets/dialog/textAngular.html'
    },

    {
      minimized: false,
      maximized: false,
      width: 200,
      height: 250,
      top: 315,
      left: 73,
      zindex: 0,
      template: 'assets/dialog/other-dialog.html'
    },

    {
      minimized: false,
      maximized: false,
      width: 200,
      height: 200,
      top: 80,
      left: 234,
      zindex: 1,
      template: 'assets/dialog/other-dialog.html'
    }
  ];

  $scope.globals = {
    maxbool: false
  };

  //should be in a separate directive?
  $scope.restore = function(dialog, dialogs) {
    dialog.minimized = false;
    var k = dialog.zindex;
    var l = dialogs.length;
    for(var i = 0; i < l; i++){
        if(dialogs[i].zindex > k) {
          dialogs[i].zindex -= 1;
        }
      }
      dialog.zindex = l-1;
  };

}]);

root.directive('makeDialog', function($document) {
return {
  restrict: 'E',
  scope: {
    model: '=',
    dialogs: '=',
    globals: '=',
		expid: '='
  },
  templateUrl: 'assets/dialog/dialog.html',
  link: function(scope, element, attrs) {
   //bring to top
   scope.zorder = function() {
      var k = scope.model.zindex;
      var l = scope.dialogs.length;
      for(var i = 0; i < l; i++){
        if(scope.dialogs[i].zindex > k) {
          scope.dialogs[i].zindex -= 1;
        }
      }
      scope.model.zindex = l-1;
    };

    //jqlite elements
    var dialog = angular.element(element[0].querySelector('.dialog'));
    var topBar = dialog.children().eq(0);
    var drag = dialog.children().eq(2);

    //minimization
    scope.minimize = function() {
      scope.model.minimized = true;
    };

    //maximization
    scope.maximize = function() {
      if(scope.model.maximized === false) {
        scope.model.maximized = true;
        scope.globals.maxbool = true;
      } else {
        scope.model.maximized = false;
        scope.globals.maxbool = false;
      }
    };

    //drag variables
    var t = scope.model.top;
    var l = scope.model.left;
    var offsetL = 0, offsetT = 0;

    //drag functions
    topBar.on('mousedown', function(event) {
      event.preventDefault();
      offsetL = event.screenX - l;
      offsetT = event.screenY - t;
      $document.on('mousemove', mousemoveDrag);
      $document.on('mouseup', mouseupDrag);
    });

    function mousemoveDrag(event) {
      l = event.screenX - offsetL;
      t = event.screenY - offsetT;
      dialog.css({
          top: Math.max(0,t) + 'px',
          left: Math.max(0,l) + 'px'
      });
    }

    function mouseupDrag(event) {
      $document.off('mousemove', mousemoveDrag);
      $document.off('mouseup', mouseupDrag);
      scope.model.top = Math.max(0,t);
      scope.model.left = Math.max(0,l);
      scope.$apply();
    }

    //resize variables
    var h = 0, w = 0, startX = 0, startY = 0;
    var minW = 100, minH = 100; //minimium allowable window size

    //resize functions
    drag.on('mousedown', function(event) {
        event.preventDefault();
        startY = event.screenY;
        startX = event.screenX;
        $document.on('mousemove', mousemoveSize);
        $document.on('mouseup', mouseupSize);
    });

    function mousemoveSize(event) {
      w = scope.model.width + event.screenX - startX;
      h = scope.model.height + event.screenY - startY;
      dialog.css({
        width: Math.max(w, minW) + 'px',
        height: Math.max(h, minH) + 'px'
      });
    }

    function mouseupSize(event) {
      $document.off('mousemove', mousemoveSize);
      $document.off('mouseup', mouseupSize);
      scope.model.width = Math.max(w, minW);
      scope.model.height = Math.max(h, minH);
      scope.$apply();
    }
  }
};
});

//Content controller
root.controller("contentController", function ($scope, $http, $modal){
	//modal operations
	$scope.animationsEnabled = false;
	$scope.open = function (size) {
	 var modalInstance = $modal.open({
		 animation: $scope.animationsEnabled,
		 templateUrl: 'addContent.html',
		 controller: 'ModalInstanceCtrl',
		 size: size
	 });

	 modalInstance.result.then(function (item) {
		 //defualt html
		 item.html = "Edit your content here!";
		 $scope.addContent(item);
	 });
 };

 $scope.warning = function (item) {
	var modalInstance = $modal.open({
		animation: $scope.animationsEnabled,
		templateUrl: 'deleteContent.html',
		controller: 'deleteModalInstanceCtrl',
		size: 'sm'
	});

	modalInstance.result.then(function () {
		$scope.removeContent(item);
	});
};

	//item operations
	$scope.items = []
	$scope.getExpContents = function(){
		if($scope.expid != null && $scope.expid != undefined && $scope.expid != ""){
			var httpRequest = $http({
				method: 'GET',
				url: "/contentlist/" + $scope.expid
			}).success(function(data, status){
				$scope.items = data;
			}).error(function(arg){
				console.log(arg);
			});
		}
		else{
			$scope.items = [];
		}
	}

	$scope.$watch('expid', $scope.getExpContents);

	$scope.addContent = function(addItem){
		addItem.experiment_id = $scope.expid;
		addItem.id = 0;//dummy id
		console.log(JSON.stringify(addItem));
		var req = $http({
			method:'POST',
			url:'/addcontent',
			data:addItem
		}).success(function(data, status){
			console.log(data);
			//re-get the list
			$scope.getExpContents($scope.expid);
		}).error(function(data, status){
			console.log(data);
		});
	}

	$scope.updateContent = function(item){
		console.log(JSON.stringify(item));
		var req = $http({
			method:'PUT',
			url:'/updatecontent',
			data:item
		}).success(function(data, status){
			console.log(data);
		}).error(function(arg){
			console.log("error");
		});
	}

	$scope.removeContent = function(item){
		console.log(JSON.stringify(item));
		var req = $http({
			method:'POST',
			url:'/deletecontent',
			data:item
		}).success(function(data, status){
			console.log(data);
			$scope.getExpContents($scope.expid);
		}).error(function(arg){
			console.log("error");
		});
	}

});


root.controller('ModalInstanceCtrl', function ($scope, $modalInstance) {
  $scope.ok = function (item) {
    $modalInstance.close(item);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});

root.controller('deleteModalInstanceCtrl', function ($scope, $modalInstance) {
  $scope.ok = function () {
    $modalInstance.close();
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});
