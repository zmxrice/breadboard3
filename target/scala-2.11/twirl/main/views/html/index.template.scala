
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
  def apply/*2.2*/():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*2.4*/("""

"""),_display_(/*4.2*/main("breadboard3")/*4.21*/ {_display_(Seq[Any](format.raw/*4.23*/("""
  """),format.raw/*5.3*/("""<div ng-controller='expController'>
		<ul id='taskbar'>
		  <div ng-repeat='dialog in dialogs'>
		    <button ng-show='dialog.minimized==true || (globals.maxbool==true && dialog.maximized == false)'
		            ng-click='restore(dialog, dialogs)'>
		            """),format.raw/*10.15*/("""{"""),format.raw/*10.16*/("""{"""),format.raw/*10.17*/("""dialog.template"""),format.raw/*10.32*/("""}"""),format.raw/*10.33*/("""}"""),format.raw/*10.34*/("""
		    """),format.raw/*11.7*/("""</button>
		  </div>
	  </ul>
  		<div id='container'>
  		  <div ng-repeat='dialog in dialogs|filter:"""),format.raw/*15.48*/("""{"""),format.raw/*15.49*/("""minimized:false"""),format.raw/*15.64*/("""}"""),format.raw/*15.65*/("""'>
  		    <make-dialog model='dialog' dialogs='dialogs' globals='globals' expid='experiment_id'></make-dialog>
  		  </div>
  		</div>

      <div class="col-md-2">
        <select ng-model="exp_id" class="form-control" ng-options="o.id as o.name for o in expOptions" ng-change="setExpId(exp_id)">
            <option value="">please select</option>
        </select>
      </div>

	</div>



""")))}),format.raw/*30.2*/("""
"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sat Aug 29 10:46:07 EDT 2015
                  SOURCE: /Users/mingxiangzhu/Desktop/anormDemo/app/views/index.scala.html
                  HASH: 70273431cd71c539e7fe31e44782b4b4133e8aea
                  MATRIX: 498->2|587->4|615->7|642->26|681->28|710->31|1002->295|1031->296|1060->297|1103->312|1132->313|1161->314|1195->321|1325->423|1354->424|1397->439|1426->440|1851->835
                  LINES: 19->2|22->2|24->4|24->4|24->4|25->5|30->10|30->10|30->10|30->10|30->10|30->10|31->11|35->15|35->15|35->15|35->15|50->30
                  -- GENERATED --
              */
          