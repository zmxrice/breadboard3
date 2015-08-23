var experimentApp = angular.module('experimentApp',['ui.bootstrap'])

experimentApp.controller('ngSelect', function($scope) {
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

experimentApp.controller('expController',function($scope, $http) {
	$scope.expOptions = []
	$http({
			method: 'GET',
			url: "/explist"
		}).success(function(data, status){
			$scope.expOptions = data;
		}).error(function(arg){
			alert("error");
		});
});

experimentApp.controller('paramController', function($scope, $http) {
	$scope.items = [];
	$scope.getExpParams = function(exp_id){
		$scope.experiment_id = exp_id;
		if(exp_id != null){
			var httpRequest = $http({
				method: 'GET',
				url: "/paramlist/" + exp_id
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

	$scope.addParam = function(addItem){
		addItem.experiment_id = $scope.experiment_id;
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
			$scope.getExpParams($scope.experiment_id);
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
			$scope.getExpParams($scope.experiment_id);
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
			$scope.getExpParams($scope.experiment_id);
		}).error(function(arg){
			console.log("error");
		});
	}

});
