
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
object dialog extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>

  <head>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.1/angular.min.js"></script>


    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,300">
    <link rel="stylesheet" href="http://textangular.com/css/style.css" type="text/css">
    <script src="https://code.angularjs.org/X.Y.Z/angular-sanitize.js" type="text/javascript"></script>

    <script src=""""),_display_(/*14.19*/routes/*14.25*/.Assets.versioned("textAngular/dist/textAngular-rangy.min.js")),format.raw/*14.87*/(""""></script>

    <script src=""""),_display_(/*16.19*/routes/*16.25*/.Assets.versioned("textAngular/dist/textAngular-sanitize.min.js")),format.raw/*16.90*/(""""></script>

    <script src=""""),_display_(/*18.19*/routes/*18.25*/.Assets.versioned("textAngular/dist/textAngular.min.js")),format.raw/*18.81*/(""""></script>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.js" type="text/javascript"></script>



    <script src=""""),_display_(/*24.19*/routes/*24.25*/.Assets.versioned("dialog/script.js")),format.raw/*24.62*/("""" type="text/javascript"></script>
    <link href=""""),_display_(/*25.18*/routes/*25.24*/.Assets.versioned("dialog/index.css")),format.raw/*25.61*/("""" rel="stylesheet" type="text/css"/>

  </head>

  <body ng-app='root' ng-controller='index'>

		<ul id='taskbar'>
		  <div ng-repeat='dialog in dialogs'>
		    <button ng-show='dialog.minimized==true || (globals.maxbool==true && dialog.maximized == false)'
		            ng-click='restore(dialog, dialogs)'>
		            """),format.raw/*35.15*/("""{"""),format.raw/*35.16*/("""{"""),format.raw/*35.17*/("""dialog.template"""),format.raw/*35.32*/("""}"""),format.raw/*35.33*/("""}"""),format.raw/*35.34*/("""
		    """),format.raw/*36.7*/("""</button>
		  </div>
	  </ul>

		<div id='container'>
		  <div ng-repeat='dialog in dialogs|filter:"""),format.raw/*41.46*/("""{"""),format.raw/*41.47*/("""minimized:false"""),format.raw/*41.62*/("""}"""),format.raw/*41.63*/("""'>
		    <make-dialog model='dialog' dialogs='dialogs' globals='globals'></make-dialog>
		  </div>
		</div>


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
                  DATE: Fri Aug 21 15:04:20 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/dialog.scala.html
                  HASH: 768a6d3816665ac37f63249586fb15db879bd052
                  MATRIX: 581->0|1253->645|1268->651|1351->713|1409->744|1424->750|1510->815|1568->846|1583->852|1660->908|1836->1057|1851->1063|1909->1100|1988->1152|2003->1158|2061->1195|2412->1518|2441->1519|2470->1520|2513->1535|2542->1536|2571->1537|2605->1544|2732->1643|2761->1644|2804->1659|2833->1660
                  LINES: 22->1|35->14|35->14|35->14|37->16|37->16|37->16|39->18|39->18|39->18|45->24|45->24|45->24|46->25|46->25|46->25|56->35|56->35|56->35|56->35|56->35|56->35|57->36|62->41|62->41|62->41|62->41
                  -- GENERATED --
              */
          