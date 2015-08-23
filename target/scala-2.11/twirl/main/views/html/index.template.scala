
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
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.4*/("""

"""),_display_(/*3.2*/main("breadboard3")/*3.21*/ {_display_(Seq[Any](format.raw/*3.23*/("""
  """),format.raw/*4.3*/("""<div ng-app = "experimentApp">
    <div ng-controller="paramController">
      <div class="row">
      <div ng-controller="expController" class="col-md-2">
        <select ng-model="exp_id" class="form-control" ng-options="o.id as o.name for o in expOptions" ng-change="getExpParams(exp_id)">
            <option value="">please select</option>
        </select>
      </div>
    </div>
      <form name="addForm" novalidate>
        <div class="row">
          <div class="col-md-1">
            <label>Name</label>
            <input type="text" class="form-control" ng-model="addItem.name" required />
          </div>

          <div class="col-md-1">
            <label>Type</label>
            <select ng-controller="ngSelect" class="form-control" ng-model="addItem.val_type" ng-options="o.val as o.title for o in optionsData" required>
          	    <option value="">select type</option>
        	  </select>
          </div>

          <div class="col-md-1">
            <label>Min.</label>
            <input type="text" class="form-control" ng-model="addItem.min_val"/>
          </div>

          <div class="col-md-1">
            <label>Max.</label>
            <input type="text" class="form-control" ng-model="addItem.max_val" />
          </div>

          <div class="col-md-1">
            <label>Default</label>
            <input type="text" class="form-control" ng-model="addItem.default_val" required/>
          </div>

          <div class="col-md-2">
            <label>Short Description</label>
            <input type="text" class="form-control" ng-model="addItem.description" />
          </div>

          <div class="col-md-1">
            <label>Operation</label>
            <button ng-disabled="addForm.$invalid" ng-click="addParam(addItem)" class="btn btn-default">add</button>
          </div>

        </div>
      </form>
      <form name="updateForm" novalidate ng-repeat="item in items">
        <div class="row">
          <div class="col-md-1">
            <input type="text" class="form-control" ng-model="item.name" required />
          </div>

          <div class="col-md-1">
            <select ng-controller="ngSelect" class="form-control" ng-model="item.val_type" ng-options="o.val as o.title for o in optionsData" required>
                <option value="">select type</option>
            </select>
          </div>

          <div class="col-md-1">
            <input type="text" class="form-control" ng-model="item.min_val"/>
          </div>

          <div class="col-md-1">
            <input type="text" class="form-control" ng-model="item.max_val" />
          </div>

          <div class="col-md-1">
            <input type="text" class="form-control" ng-model="item.default_val" required/>
          </div>

          <div class="col-md-2">
            <input type="text" class="form-control" ng-model="item.description" />
          </div>

          <div class="col-md-2">
            <button ng-disabled="updateForm.$invalid" ng-click="updateParam(item)" class="btn btn-default">update</button>
            <button ng-click="removeParam(item)" class="btn btn-default">delete</button>
          </div>

        </div>

      </form>
    </div>
  </div>

  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">

  <!-- Optional theme -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">

  <link rel="stylesheet" href=""""),_display_(/*99.33*/routes/*99.39*/.Assets.versioned("stylesheets/main.css")),format.raw/*99.80*/("""">

  <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.3.13/angular.min.js"></script>
  <script src=""""),_display_(/*102.17*/routes/*102.23*/.Assets.versioned("javascripts/ui-bootstrap-tpls-0.13.0.min.js")),format.raw/*102.87*/("""" type="text/javascript"></script>
  <script src=""""),_display_(/*103.17*/routes/*103.23*/.Assets.versioned("javascripts/app.js")),format.raw/*103.62*/("""" type="text/javascript"></script>
""")))}),format.raw/*104.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Jun 19 12:43:40 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/index.scala.html
                  HASH: 2df1dc0262f5ece0291469782006a05f74bc1bc8
                  MATRIX: 498->1|587->3|615->6|642->25|681->27|710->30|4271->3564|4286->3570|4348->3611|4486->3721|4502->3727|4588->3791|4667->3842|4683->3848|4744->3887|4811->3923
                  LINES: 19->1|22->1|24->3|24->3|24->3|25->4|120->99|120->99|120->99|123->102|123->102|123->102|124->103|124->103|124->103|125->104
                  -- GENERATED --
              */
          