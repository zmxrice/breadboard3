
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/mingxiangzhu/Desktop/anormDemo/conf/routes
// @DATE:Mon Jun 15 17:17:45 EDT 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
