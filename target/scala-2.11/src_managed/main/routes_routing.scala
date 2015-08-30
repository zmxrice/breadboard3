// @SOURCE:/Users/mingxiangzhu/Desktop/anormDemo/conf/routes
// @HASH:41f556be97923c5c3952d72e94f387b164e2a3f4
// @DATE:Sat Aug 29 16:52:05 EDT 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String): Unit = {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:7
private[this] lazy val controllers_Application_login1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_Application_login1_invoker = createInvoker(
controllers.Application.login,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "login", Nil,"GET", """""", Routes.prefix + """login"""))
        

// @LINE:8
private[this] lazy val controllers_Application_getExps2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("explist"))))
private[this] lazy val controllers_Application_getExps2_invoker = createInvoker(
controllers.Application.getExps,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getExps", Nil,"GET", """""", Routes.prefix + """explist"""))
        

// @LINE:9
private[this] lazy val controllers_Application_getParams3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("paramlist/"),DynamicPart("exp_id", """[^/]+""",true))))
private[this] lazy val controllers_Application_getParams3_invoker = createInvoker(
controllers.Application.getParams(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "getParams", Seq(classOf[Long]),"GET", """""", Routes.prefix + """paramlist/$exp_id<[^/]+>"""))
        

// @LINE:10
private[this] lazy val controllers_Application_addParameter4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addparam"))))
private[this] lazy val controllers_Application_addParameter4_invoker = createInvoker(
controllers.Application.addParameter,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "addParameter", Nil,"POST", """""", Routes.prefix + """addparam"""))
        

// @LINE:11
private[this] lazy val controllers_Application_updateParameter5_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updateparam"))))
private[this] lazy val controllers_Application_updateParameter5_invoker = createInvoker(
controllers.Application.updateParameter,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "updateParameter", Nil,"PUT", """""", Routes.prefix + """updateparam"""))
        

// @LINE:12
private[this] lazy val controllers_Application_deleteParameter6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteparam"))))
private[this] lazy val controllers_Application_deleteParameter6_invoker = createInvoker(
controllers.Application.deleteParameter,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteParameter", Nil,"POST", """""", Routes.prefix + """deleteparam"""))
        

// @LINE:14
private[this] lazy val controllers_Application_d37_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("d3"))))
private[this] lazy val controllers_Application_d37_invoker = createInvoker(
controllers.Application.d3,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "d3", Nil,"GET", """D3.js test""", Routes.prefix + """d3"""))
        

// @LINE:15
private[this] lazy val controllers_Application_d3json8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("myjson"))))
private[this] lazy val controllers_Application_d3json8_invoker = createInvoker(
controllers.Application.d3json,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "d3json", Nil,"GET", """""", Routes.prefix + """myjson"""))
        

// @LINE:17
private[this] lazy val controllers_Application_ace9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ace"))))
private[this] lazy val controllers_Application_ace9_invoker = createInvoker(
controllers.Application.ace,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "ace", Nil,"GET", """ACE IDE""", Routes.prefix + """ace"""))
        

// @LINE:20
private[this] lazy val controllers_Application_textAngular10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("textAngular"))))
private[this] lazy val controllers_Application_textAngular10_invoker = createInvoker(
controllers.Application.textAngular,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "textAngular", Nil,"GET", """Text Angular""", Routes.prefix + """textAngular"""))
        

// @LINE:23
private[this] lazy val controllers_Application_dialog11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("dialog"))))
private[this] lazy val controllers_Application_dialog11_invoker = createInvoker(
controllers.Application.dialog,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "dialog", Nil,"GET", """Dialog Angular""", Routes.prefix + """dialog"""))
        

// @LINE:26
private[this] lazy val controllers_GraphGenerator_randomGraph12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("graph"))))
private[this] lazy val controllers_GraphGenerator_randomGraph12_invoker = createInvoker(
controllers.GraphGenerator.randomGraph,
HandlerDef(this.getClass.getClassLoader, "", "controllers.GraphGenerator", "randomGraph", Nil,"GET", """graph""", Routes.prefix + """graph"""))
        

// @LINE:29
private[this] lazy val controllers_ExpContent_getContent13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("contentlist/"),DynamicPart("exp_id", """[^/]+""",true))))
private[this] lazy val controllers_ExpContent_getContent13_invoker = createInvoker(
controllers.ExpContent.getContent(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.ExpContent", "getContent", Seq(classOf[Long]),"GET", """content Controller""", Routes.prefix + """contentlist/$exp_id<[^/]+>"""))
        

// @LINE:30
private[this] lazy val controllers_ExpContent_addContent14_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addcontent"))))
private[this] lazy val controllers_ExpContent_addContent14_invoker = createInvoker(
controllers.ExpContent.addContent,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ExpContent", "addContent", Nil,"POST", """""", Routes.prefix + """addcontent"""))
        

// @LINE:31
private[this] lazy val controllers_ExpContent_updateContent15_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("updatecontent"))))
private[this] lazy val controllers_ExpContent_updateContent15_invoker = createInvoker(
controllers.ExpContent.updateContent,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ExpContent", "updateContent", Nil,"PUT", """""", Routes.prefix + """updatecontent"""))
        

// @LINE:32
private[this] lazy val controllers_ExpContent_deleteContent16_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deletecontent"))))
private[this] lazy val controllers_ExpContent_deleteContent16_invoker = createInvoker(
controllers.ExpContent.deleteContent,
HandlerDef(this.getClass.getClassLoader, "", "controllers.ExpContent", "deleteContent", Nil,"POST", """""", Routes.prefix + """deletecontent"""))
        

// @LINE:35
private[this] lazy val controllers_Assets_versioned17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned17_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[Asset]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[Asset]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.Application.login"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """explist""","""controllers.Application.getExps"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """paramlist/$exp_id<[^/]+>""","""controllers.Application.getParams(exp_id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addparam""","""controllers.Application.addParameter"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updateparam""","""controllers.Application.updateParameter"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteparam""","""controllers.Application.deleteParameter"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """d3""","""controllers.Application.d3"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """myjson""","""controllers.Application.d3json"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ace""","""controllers.Application.ace"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """textAngular""","""controllers.Application.textAngular"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """dialog""","""controllers.Application.dialog"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """graph""","""controllers.GraphGenerator.randomGraph"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contentlist/$exp_id<[^/]+>""","""controllers.ExpContent.getContent(exp_id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addcontent""","""controllers.ExpContent.addContent"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """updatecontent""","""controllers.ExpContent.updateContent"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deletecontent""","""controllers.ExpContent.deleteContent"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:Asset)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index)
   }
}
        

// @LINE:7
case controllers_Application_login1_route(params) => {
   call { 
        controllers_Application_login1_invoker.call(controllers.Application.login)
   }
}
        

// @LINE:8
case controllers_Application_getExps2_route(params) => {
   call { 
        controllers_Application_getExps2_invoker.call(controllers.Application.getExps)
   }
}
        

// @LINE:9
case controllers_Application_getParams3_route(params) => {
   call(params.fromPath[Long]("exp_id", None)) { (exp_id) =>
        controllers_Application_getParams3_invoker.call(controllers.Application.getParams(exp_id))
   }
}
        

// @LINE:10
case controllers_Application_addParameter4_route(params) => {
   call { 
        controllers_Application_addParameter4_invoker.call(controllers.Application.addParameter)
   }
}
        

// @LINE:11
case controllers_Application_updateParameter5_route(params) => {
   call { 
        controllers_Application_updateParameter5_invoker.call(controllers.Application.updateParameter)
   }
}
        

// @LINE:12
case controllers_Application_deleteParameter6_route(params) => {
   call { 
        controllers_Application_deleteParameter6_invoker.call(controllers.Application.deleteParameter)
   }
}
        

// @LINE:14
case controllers_Application_d37_route(params) => {
   call { 
        controllers_Application_d37_invoker.call(controllers.Application.d3)
   }
}
        

// @LINE:15
case controllers_Application_d3json8_route(params) => {
   call { 
        controllers_Application_d3json8_invoker.call(controllers.Application.d3json)
   }
}
        

// @LINE:17
case controllers_Application_ace9_route(params) => {
   call { 
        controllers_Application_ace9_invoker.call(controllers.Application.ace)
   }
}
        

// @LINE:20
case controllers_Application_textAngular10_route(params) => {
   call { 
        controllers_Application_textAngular10_invoker.call(controllers.Application.textAngular)
   }
}
        

// @LINE:23
case controllers_Application_dialog11_route(params) => {
   call { 
        controllers_Application_dialog11_invoker.call(controllers.Application.dialog)
   }
}
        

// @LINE:26
case controllers_GraphGenerator_randomGraph12_route(params) => {
   call { 
        controllers_GraphGenerator_randomGraph12_invoker.call(controllers.GraphGenerator.randomGraph)
   }
}
        

// @LINE:29
case controllers_ExpContent_getContent13_route(params) => {
   call(params.fromPath[Long]("exp_id", None)) { (exp_id) =>
        controllers_ExpContent_getContent13_invoker.call(controllers.ExpContent.getContent(exp_id))
   }
}
        

// @LINE:30
case controllers_ExpContent_addContent14_route(params) => {
   call { 
        controllers_ExpContent_addContent14_invoker.call(controllers.ExpContent.addContent)
   }
}
        

// @LINE:31
case controllers_ExpContent_updateContent15_route(params) => {
   call { 
        controllers_ExpContent_updateContent15_invoker.call(controllers.ExpContent.updateContent)
   }
}
        

// @LINE:32
case controllers_ExpContent_deleteContent16_route(params) => {
   call { 
        controllers_ExpContent_deleteContent16_invoker.call(controllers.ExpContent.deleteContent)
   }
}
        

// @LINE:35
case controllers_Assets_versioned17_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned17_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     