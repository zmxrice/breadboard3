
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mingxiangzhu/Desktop/anormDemo/conf/routes
// @DATE:Mon Jun 15 17:17:45 EDT 2015

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:14
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:14
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseApplication(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def updateParameter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.updateParameter",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "updateparam"})
        }
      """
    )
  
    // @LINE:8
    def getParams: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getParams",
      """
        function(exp_id) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paramlist/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("exp_id", exp_id)})
        }
      """
    )
  
    // @LINE:11
    def deleteParameter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.deleteParameter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteparam"})
        }
      """
    )
  
    // @LINE:9
    def addParameter: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.addParameter",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addparam"})
        }
      """
    )
  
    // @LINE:7
    def getExps: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.getExps",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "explist"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Application.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }


}