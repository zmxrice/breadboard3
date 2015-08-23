// @SOURCE:/Users/mingxiangzhu/Desktop/anormDemo/conf/routes
// @HASH:461fe3b9800e1f59179cb678c4850d8e8ce28fd1
// @DATE:Tue Aug 18 10:11:52 EDT 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:30
// @LINE:26
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:26
class ReverseGraphGenerator {


// @LINE:26
def randomGraph(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "graph")
}
                        

}
                          

// @LINE:30
class ReverseAssets {


// @LINE:30
def versioned(file:Asset): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[Asset]].unbind("file", file))
}
                        

}
                          

// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:17
def ace(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ace")
}
                        

// @LINE:11
def updateParameter(): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "updateparam")
}
                        

// @LINE:15
def d3json(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "myjson")
}
                        

// @LINE:20
def textAngular(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "textAngular")
}
                        

// @LINE:23
def dialog(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "dialog")
}
                        

// @LINE:9
def getParams(exp_id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "paramlist/" + implicitly[PathBindable[Long]].unbind("exp_id", exp_id))
}
                        

// @LINE:14
def d3(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "d3")
}
                        

// @LINE:12
def deleteParameter(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "deleteparam")
}
                        

// @LINE:10
def addParameter(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "addparam")
}
                        

// @LINE:8
def getExps(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "explist")
}
                        

// @LINE:6
def index(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix)
}
                        

// @LINE:7
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          
}
                  


// @LINE:30
// @LINE:26
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:26
class ReverseGraphGenerator {


// @LINE:26
def randomGraph : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.GraphGenerator.randomGraph",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "graph"})
      }
   """
)
                        

}
              

// @LINE:30
class ReverseAssets {


// @LINE:30
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:17
def ace : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.ace",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ace"})
      }
   """
)
                        

// @LINE:11
def updateParameter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.updateParameter",
   """
      function() {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "updateparam"})
      }
   """
)
                        

// @LINE:15
def d3json : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.d3json",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "myjson"})
      }
   """
)
                        

// @LINE:20
def textAngular : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.textAngular",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "textAngular"})
      }
   """
)
                        

// @LINE:23
def dialog : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.dialog",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "dialog"})
      }
   """
)
                        

// @LINE:9
def getParams : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getParams",
   """
      function(exp_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paramlist/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("exp_id", exp_id)})
      }
   """
)
                        

// @LINE:14
def d3 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.d3",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "d3"})
      }
   """
)
                        

// @LINE:12
def deleteParameter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.deleteParameter",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteparam"})
      }
   """
)
                        

// @LINE:10
def addParameter : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.addParameter",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addparam"})
      }
   """
)
                        

// @LINE:8
def getExps : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getExps",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "explist"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        

// @LINE:7
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              
}
        


// @LINE:30
// @LINE:26
// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:26
class ReverseGraphGenerator {


// @LINE:26
def randomGraph(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.GraphGenerator.randomGraph(), HandlerDef(this.getClass.getClassLoader, "", "controllers.GraphGenerator", "randomGraph", Seq(), "GET", """graph""", _prefix + """graph""")
)
                      

}
                          

// @LINE:30
class ReverseAssets {


// @LINE:30
def versioned(path:String, file:Asset): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:23
// @LINE:20
// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:17
def ace(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.ace(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ace", Seq(), "GET", """ACE IDE""", _prefix + """ace""")
)
                      

// @LINE:11
def updateParameter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.updateParameter(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateParameter", Seq(), "PUT", """""", _prefix + """updateparam""")
)
                      

// @LINE:15
def d3json(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.d3json(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "d3json", Seq(), "GET", """""", _prefix + """myjson""")
)
                      

// @LINE:20
def textAngular(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.textAngular(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "textAngular", Seq(), "GET", """Text Angular""", _prefix + """textAngular""")
)
                      

// @LINE:23
def dialog(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.dialog(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dialog", Seq(), "GET", """Dialog Angular""", _prefix + """dialog""")
)
                      

// @LINE:9
def getParams(exp_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getParams(exp_id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getParams", Seq(classOf[Long]), "GET", """""", _prefix + """paramlist/$exp_id<[^/]+>""")
)
                      

// @LINE:14
def d3(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.d3(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "d3", Seq(), "GET", """D3.js test""", _prefix + """d3""")
)
                      

// @LINE:12
def deleteParameter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.deleteParameter(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteParameter", Seq(), "POST", """""", _prefix + """deleteparam""")
)
                      

// @LINE:10
def addParameter(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.addParameter(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addParameter", Seq(), "POST", """""", _prefix + """addparam""")
)
                      

// @LINE:8
def getExps(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getExps(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getExps", Seq(), "GET", """""", _prefix + """explist""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      

// @LINE:7
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Seq(), "GET", """""", _prefix + """login""")
)
                      

}
                          
}
        
    