
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
object index2 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.5*/("""<div ng-controller="paramController">
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
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Aug 27 10:09:31 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/index2.scala.html
                  HASH: 5a4a19007a4d5fbb486cc5484cb499edf0053aa9
                  MATRIX: 581->5
                  LINES: 22->2
                  -- GENERATED --
              */
          