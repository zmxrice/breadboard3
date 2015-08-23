
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
object graph extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(content: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.19*/("""

"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Graph</title>
    </head>
    <body>
        """),_display_(/*10.10*/content),format.raw/*10.17*/("""
    """),format.raw/*11.5*/("""</body>
</html>
"""))}
  }

  def render(content:String): play.twirl.api.HtmlFormat.Appendable = apply(content)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (content) => apply(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Jul 21 12:52:26 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/graph.scala.html
                  HASH: ec3a25aa8a20aca34a3e5c1f5f92531060a091fa
                  MATRIX: 505->2|610->19|638->21|770->126|798->133|830->138
                  LINES: 19->2|22->2|24->4|30->10|30->10|31->11
                  -- GENERATED --
              */
          