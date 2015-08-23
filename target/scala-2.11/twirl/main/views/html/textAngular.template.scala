
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
object textAngular extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
    <meta charset="utf-8">
    <title>textAngular</title>
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,300">
    <link rel="stylesheet" href="http://textangular.com/css/style.css" type="text/css">
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.11/angular.min.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/X.Y.Z/angular-sanitize.js" type="text/javascript"></script>

        <script src=""""),_display_(/*14.23*/routes/*14.29*/.Assets.versioned("textAngular/dist/textAngular-rangy.min.js")),format.raw/*14.91*/(""""></script>

        <script src=""""),_display_(/*16.23*/routes/*16.29*/.Assets.versioned("textAngular/dist/textAngular-sanitize.min.js")),format.raw/*16.94*/(""""></script>

        <script src=""""),_display_(/*18.23*/routes/*18.29*/.Assets.versioned("textAngular/dist/textAngular.min.js")),format.raw/*18.85*/(""""></script>

    <script src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r298/prettify.js" type="text/javascript"></script>
</head>
<body>
    <div id="ng-app" ng-app="textAngularDemo" ng-controller="demoController" class="ng-scope">
        <br>
        <div class="container">
            <a href="http://github.com/fraywing/textAngular"> <img src="http://textangular.com/images/textAngularLogo.png" style="max-width:500%;" class="lighter"></a>
        </div>
        <div class="container lighter">
            <div text-angular ng-model="htmlContent" name="demo-editor" ta-text-editor-class="border-around container" ta-html-editor-class="border-around"></div>
        </div>
        <br>
        <div class="container text-center lighter border-around">
            <div class="lighter roboto">
                <p ng-bind-html="htmlContent" class="text-left text-med text-gray"></p>
            </div>
        </div>
    </div>

    <script type="text/javascript">
    angular.module("textAngularDemo", ['textAngular','ngSanitize'])
    .controller("demoController", function demoController($scope) """),format.raw/*41.67*/("""{"""),format.raw/*41.68*/("""
      """),format.raw/*42.7*/("""$scope.htmlContent = '<h2>Try me!</h2><p>textAngular is a super cool WYSIWYG Text Editor directive for AngularJS</p><p><b>Features:</b></p><ol><li>Automatic Seamless Two-Way-Binding</li><li style="color: blue;">Super Easy <b>Theming</b> Options</li><li>Simple Editor Instance Creation</li><li>Safely Parses Html for Custom Toolbar Icons</li><li>Doesn&apos;t Use an iFrame</li><li>Works with Firefox, Chrome, and IE9+</li></ol><p><b>Code at GitHub:</b> <a href="https://github.com/fraywing/textAngular">Here</a> </p>';
    """),format.raw/*43.5*/("""}"""),format.raw/*43.6*/(""");
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
                  DATE: Thu Aug 13 10:33:03 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/textAngular.scala.html
                  HASH: 704bd2abacfc2dea4e45f3505c5f1ef4541903c4
                  MATRIX: 586->0|1435->822|1450->828|1533->890|1595->925|1610->931|1696->996|1758->1031|1773->1037|1850->1093|2986->2201|3015->2202|3049->2209|3598->2731|3626->2732
                  LINES: 22->1|35->14|35->14|35->14|37->16|37->16|37->16|39->18|39->18|39->18|62->41|62->41|63->42|64->43|64->43
                  -- GENERATED --
              */
          