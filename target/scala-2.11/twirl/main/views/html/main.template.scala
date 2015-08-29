
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
        <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular.min.js"></script>
          <!-- for dialog and text angular part -->
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,300">
        <link rel="stylesheet" href="http://textangular.com/css/style.css" type="text/css">
        <script src=""""),_display_(/*13.23*/routes/*13.29*/.Assets.versioned("textAngular/dist/textAngular-rangy.min.js")),format.raw/*13.91*/(""""></script>

        <script src=""""),_display_(/*15.23*/routes/*15.29*/.Assets.versioned("textAngular/dist/textAngular-sanitize.min.js")),format.raw/*15.94*/(""""></script>

        <script src=""""),_display_(/*17.23*/routes/*17.29*/.Assets.versioned("textAngular/dist/textAngular.min.js")),format.raw/*17.85*/(""""></script>

        <script src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.js" type="text/javascript"></script>
        <link href=""""),_display_(/*20.22*/routes/*20.28*/.Assets.versioned("dialog/index.css")),format.raw/*20.65*/("""" rel="stylesheet" type="text/css"/>

          <!-- for parameter part -->
        <link rel="stylesheet" href=""""),_display_(/*23.39*/routes/*23.45*/.Assets.versioned("stylesheets/main.css")),format.raw/*23.86*/("""">
        <script src=""""),_display_(/*24.23*/routes/*24.29*/.Assets.versioned("javascripts/ui-bootstrap-tpls-0.13.0.min.js")),format.raw/*24.93*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/app.js")),format.raw/*25.68*/("""" type="text/javascript"></script>
    </head>
    <body ng-app="root">
        """),_display_(/*28.10*/content),format.raw/*28.17*/("""
    """),format.raw/*29.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Aug 27 14:09:48 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/main.scala.html
                  HASH: e15dd63bfcde8099d9735db81252bd77576e6e49
                  MATRIX: 509->1|627->31|655->33|741->93|766->98|1383->688|1398->694|1481->756|1543->791|1558->797|1644->862|1706->897|1721->903|1798->959|1978->1112|1993->1118|2051->1155|2192->1269|2207->1275|2269->1316|2321->1341|2336->1347|2421->1411|2505->1468|2520->1474|2580->1513|2688->1594|2716->1601|2748->1606
                  LINES: 19->1|22->1|24->3|27->6|27->6|34->13|34->13|34->13|36->15|36->15|36->15|38->17|38->17|38->17|41->20|41->20|41->20|44->23|44->23|44->23|45->24|45->24|45->24|46->25|46->25|46->25|49->28|49->28|50->29
                  -- GENERATED --
              */
          