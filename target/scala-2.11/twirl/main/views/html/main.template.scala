
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
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>"""),_display_(/*6.17*/title),format.raw/*6.22*/("""</title>
    </head>
    <body>
        """),_display_(/*9.10*/content),format.raw/*9.17*/("""
    """),format.raw/*10.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Jun 19 13:10:38 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/main.scala.html
                  HASH: 6ad8052c6dd8a786d5acd2851a522a1ace505240
                  MATRIX: 509->1|627->31|655->33|741->93|766->98|833->139|860->146|892->151
                  LINES: 19->1|22->1|24->3|27->6|27->6|30->9|30->9|31->10
                  -- GENERATED --
              */
          