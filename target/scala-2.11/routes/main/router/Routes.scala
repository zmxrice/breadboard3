
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mingxiangzhu/Desktop/anormDemo/conf/routes
// @DATE:Mon Jun 15 17:17:45 EDT 2015

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  Application_1: controllers.Application,
  // @LINE:14
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    Application_1: controllers.Application,
    // @LINE:14
    Assets_0: controllers.Assets
  ) = this(errorHandler, Application_1, Assets_0, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, Application_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.Application.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """explist""", """controllers.Application.getExps"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paramlist/$exp_id<[^/]+>""", """controllers.Application.getParams(exp_id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addparam""", """controllers.Application.addParameter"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateparam""", """controllers.Application.updateParameter"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """deleteparam""", """controllers.Application.deleteParameter"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_Application_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_Application_index0_invoker = createInvoker(
    Application_1.index,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "index",
      Nil,
      "GET",
      """ Home page""",
      this.prefix + """"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_Application_getExps1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("explist")))
  )
  private[this] lazy val controllers_Application_getExps1_invoker = createInvoker(
    Application_1.getExps,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getExps",
      Nil,
      "GET",
      """""",
      this.prefix + """explist"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Application_getParams2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paramlist/"), DynamicPart("exp_id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_Application_getParams2_invoker = createInvoker(
    Application_1.getParams(fakeValue[Long]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "getParams",
      Seq(classOf[Long]),
      "GET",
      """""",
      this.prefix + """paramlist/$exp_id<[^/]+>"""
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Application_addParameter3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addparam")))
  )
  private[this] lazy val controllers_Application_addParameter3_invoker = createInvoker(
    Application_1.addParameter,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "addParameter",
      Nil,
      "POST",
      """""",
      this.prefix + """addparam"""
    )
  )

  // @LINE:10
  private[this] lazy val controllers_Application_updateParameter4_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateparam")))
  )
  private[this] lazy val controllers_Application_updateParameter4_invoker = createInvoker(
    Application_1.updateParameter,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "updateParameter",
      Nil,
      "PUT",
      """""",
      this.prefix + """updateparam"""
    )
  )

  // @LINE:11
  private[this] lazy val controllers_Application_deleteParameter5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("deleteparam")))
  )
  private[this] lazy val controllers_Application_deleteParameter5_invoker = createInvoker(
    Application_1.deleteParameter,
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Application",
      "deleteParameter",
      Nil,
      "POST",
      """""",
      this.prefix + """deleteparam"""
    )
  )

  // @LINE:14
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """ Map static resources from the /public folder to the /assets URL path""",
      this.prefix + """assets/$file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_Application_index0_route(params) =>
      call { 
        controllers_Application_index0_invoker.call(Application_1.index)
      }
  
    // @LINE:7
    case controllers_Application_getExps1_route(params) =>
      call { 
        controllers_Application_getExps1_invoker.call(Application_1.getExps)
      }
  
    // @LINE:8
    case controllers_Application_getParams2_route(params) =>
      call(params.fromPath[Long]("exp_id", None)) { (exp_id) =>
        controllers_Application_getParams2_invoker.call(Application_1.getParams(exp_id))
      }
  
    // @LINE:9
    case controllers_Application_addParameter3_route(params) =>
      call { 
        controllers_Application_addParameter3_invoker.call(Application_1.addParameter)
      }
  
    // @LINE:10
    case controllers_Application_updateParameter4_route(params) =>
      call { 
        controllers_Application_updateParameter4_invoker.call(Application_1.updateParameter)
      }
  
    // @LINE:11
    case controllers_Application_deleteParameter5_route(params) =>
      call { 
        controllers_Application_deleteParameter5_invoker.call(Application_1.deleteParameter)
      }
  
    // @LINE:14
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_0.versioned(path, file))
      }
  }
}