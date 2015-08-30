
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
        <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular-animate.js"></script>
          <!-- for dialog and text angular part -->
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
        <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,300">
        <link rel="stylesheet" href="http://textangular.com/css/style.css" type="text/css">
        <script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.versioned("textAngular/dist/textAngular-rangy.min.js")),format.raw/*14.91*/(""""></script>

        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.versioned("textAngular/dist/textAngular-sanitize.min.js")),format.raw/*16.94*/(""""></script>

        <script src=""""),_display_(/*18.23*/routes/*18.29*/.Assets.versioned("textAngular/dist/textAngular.min.js")),format.raw/*18.85*/(""""></script>

        <script src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.js" type="text/javascript"></script>
        <link href=""""),_display_(/*21.22*/routes/*21.28*/.Assets.versioned("dialog/index.css")),format.raw/*21.65*/("""" rel="stylesheet" type="text/css"/>

          <!-- for parameter part -->
        <link rel="stylesheet" href=""""),_display_(/*24.39*/routes/*24.45*/.Assets.versioned("stylesheets/main.css")),format.raw/*24.86*/("""">
        <script src=""""),_display_(/*25.23*/routes/*25.29*/.Assets.versioned("javascripts/ui-bootstrap-tpls-0.13.0.min.js")),format.raw/*25.93*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*26.23*/routes/*26.29*/.Assets.versioned("javascripts/app.js")),format.raw/*26.68*/("""" type="text/javascript"></script>
    </head>
    <body ng-app="root">
        """),_display_(/*29.10*/content),format.raw/*29.17*/("""
    """),format.raw/*30.5*/("""</body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Aug 30 11:01:57 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/main.scala.html
                  HASH: 53fd09379b4a7ce7c5e566fafd8491007a374e64
                  MATRIX: 509->1|627->31|655->33|741->93|766->98|1482->787|1497->793|1580->855|1642->890|1657->896|1743->961|1805->996|1820->1002|1897->1058|2077->1211|2092->1217|2150->1254|2291->1368|2306->1374|2368->1415|2420->1440|2435->1446|2520->1510|2604->1567|2619->1573|2679->1612|2787->1693|2815->1700|2847->1705
                  LINES: 19->1|22->1|24->3|27->6|27->6|35->14|35->14|35->14|37->16|37->16|37->16|39->18|39->18|39->18|42->21|42->21|42->21|45->24|45->24|45->24|46->25|46->25|46->25|47->26|47->26|47->26|50->29|50->29|51->30
                  -- GENERATED --
              */
          