
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._

/**/
object ace extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
<title>ACE in Action</title>
<style type="text/css" media="screen">
    #editor """),format.raw/*8.13*/("""{"""),format.raw/*8.14*/("""
        """),format.raw/*9.9*/("""position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
    """),format.raw/*14.5*/("""}"""),format.raw/*14.6*/("""
"""),format.raw/*15.1*/("""</style>
</head>
<body>

<div id="editor">function foo(items) """),format.raw/*19.38*/("""{"""),format.raw/*19.39*/("""
    """),format.raw/*20.5*/("""var x = "All this is syntax highlighted";
    return x;
"""),format.raw/*22.1*/("""}"""),format.raw/*22.2*/("""</div>

<script src=""""),_display_(/*24.15*/routes/*24.21*/.Assets.versioned("ace-builds/src-noconflict/ace.js")),format.raw/*24.74*/("""" type="text/javascript" charset="utf-8"></script>
<script>
    var editor = ace.edit("editor");
    editor.setTheme("ace/theme/monokai");
    editor.getSession().setMode("ace/mode/scala");
</script>
</body>
</html>
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Jul 02 16:54:31 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/ace.scala.html
                  HASH: 05b5715ad0a4f3b9f736f0ce80fa0ef1042b2d67
                  MATRIX: 496->1|585->3|613->5|760->125|788->126|823->135|944->229|972->230|1000->231|1090->293|1119->294|1151->299|1234->355|1262->356|1311->378|1326->384|1400->437
                  LINES: 19->1|22->1|24->3|29->8|29->8|30->9|35->14|35->14|36->15|40->19|40->19|41->20|43->22|43->22|45->24|45->24|45->24
                  -- GENERATED --
              */
          