package controllers

import play.api._
import play.api.mvc._
import models.ParameterModel._
import models.ExperimentModel._

import play.api.libs.json._
// read json request
import play.api.libs.functional.syntax._

object Application extends Controller {
  def login = Action {
    Ok(views.html.login())
  }

  def index = Action {
    Ok(views.html.index())
  }

  def getExps = Action {
    implicit val expWrites = Json.writes[Experiment]
    val exps: List[Experiment] = getAnotherExpList
    Ok(Json.toJson(exps))
  }

  def getParams(exp_id: Long) = Action {
    implicit val paramWrites = Json.writes[Parameter]
    val params: List[Parameter] = getParamList(exp_id)
    Ok(Json.toJson(params))
  }

  implicit val paramReads: Reads[Parameter] = (
    (JsPath \ "id").read[Long] and
    (JsPath \ "experiment_id").read[Long] and
    (JsPath \ "name").read[String] and
    (JsPath \ "val_type").formatNullable[String] and
    (JsPath \ "min_val").formatNullable[String] and
    (JsPath \ "max_val").formatNullable[String] and
    (JsPath \ "default_val").formatNullable[String] and
    (JsPath \ "description").formatNullable[String]
  )(Parameter.apply _)

  def addParameter = Action(parse.json) { request =>
    val paramJson = request.body
    val parameter = paramJson.as[Parameter]
    try{
      insertParam(parameter)
      Ok("Insert Saved")
    }
    catch{
      case e =>
      Ok(e.toString())
    }
  }

  def updateParameter = Action(parse.json) { request =>
    val paramJson = request.body
    val parameter = paramJson.as[Parameter]
    try{
      updateParam(parameter)
      Ok("update Saved")
    }
    catch{
      case e:IllegalArgumentException =>
      BadRequest("Paramter not updated")
    }
  }

  def deleteParameter = Action(parse.json) { request =>
    val paramJson = request.body
    val parameter = paramJson.as[Parameter]
    try{
      deleteParam(parameter)
      Ok("deletion Saved")
    }
    catch{
      case e =>
      Ok(e.toString())
    }
  }

  def d3 = Action{
    Ok(views.html.d3())
  }

  def ace = Action{
    Ok(views.html.ace())
  }

  def textAngular = Action{
    Ok(views.html.textAngular())
  }

  def dialog = Action{
    Ok(views.html.dialog())
  }

  def d3json = Action{
    val json: JsValue = Json.parse("""
      {
  "nodes":[
    {"id":"Myriel","group":1,"test":33},
    {"id":"Napoleon","group":1,"test2":12},
    {"id":"Mlle.Baptistine","group":1},
    {"id":"Mme.Magloire","group":1},
    {"id":"CountessdeLo","group":1},
    {"id":"Geborand","group":1},
    {"id":"Champtercier","group":1},
    {"id":"Cravatte","group":1},
    {"id":"Count","group":1},
    {"id":"OldMan","group":1},
    {"id":"Labarre","group":2},
    {"id":"Valjean","group":2},
    {"id":"Marguerite","group":3},
    {"id":"Mme.deR","group":2},
    {"id":"Isabeau","group":2},
    {"id":"Gervais","group":2},
    {"id":"Tholomyes","group":3},
    {"id":"Listolier","group":3},
    {"id":"Fameuil","group":3},
    {"id":"Blacheville","group":3},
    {"id":"Favourite","group":3},
    {"id":"Dahlia","group":3},
    {"id":"Zephine","group":3},
    {"id":"Fantine","group":3},
    {"id":"Mme.Thenardier","group":4},
    {"id":"Thenardier","group":4},
    {"id":"Cosette","group":5},
    {"id":"Javert","group":4},
    {"id":"Fauchelevent","group":0},
    {"id":"Bamatabois","group":2},
    {"id":"Perpetue","group":3},
    {"id":"Simplice","group":2},
    {"id":"Scaufflaire","group":2},
    {"id":"Woman1","group":2},
    {"id":"Judge","group":2},
    {"id":"Champmathieu","group":2},
    {"id":"Brevet","group":2},
    {"id":"Chenildieu","group":2},
    {"id":"Cochepaille","group":2},
    {"id":"Pontmercy","group":4},
    {"id":"Boulatruelle","group":6},
    {"id":"Eponine","group":4},
    {"id":"Anzelma","group":4},
    {"id":"Woman2","group":5},
    {"id":"MotherInnocent","group":0},
    {"id":"Gribier","group":0},
    {"id":"Jondrette","group":7},
    {"id":"Mme.Burgon","group":7},
    {"id":"Gavroche","group":8},
    {"id":"Gillenormand","group":5},
    {"id":"Magnon","group":5},
    {"id":"Mlle.Gillenormand","group":5},
    {"id":"Mme.Pontmercy","group":5},
    {"id":"Mlle.Vaubois","group":5},
    {"id":"Lt.Gillenormand","group":5},
    {"id":"Marius","group":8},
    {"id":"BaronessT","group":5},
    {"id":"Mabeuf","group":8},
    {"id":"Enjolras","group":8},
    {"id":"Combeferre","group":8},
    {"id":"Prouvaire","group":8},
    {"id":"Feuilly","group":8},
    {"id":"Courfeyrac","group":8},
    {"id":"Bahorel","group":8},
    {"id":"Bossuet","group":8},
    {"id":"Joly","group":8},
    {"id":"Grantaire","group":8},
    {"id":"MotherPlutarch","group":9},
    {"id":"Gueulemer","group":4},
    {"id":"Babet","group":4},
    {"id":"Claquesous","group":4},
    {"id":"Montparnasse","group":4},
    {"id":"Toussaint","group":5},
    {"id":"Child1","group":10},
    {"id":"Child2","group":10},
    {"id":"Brujon","group":4},
    {"id":"Mme.Hucheloup","group":8}
  ],
  "links":[
    {"source":1,"target":0,"value":1},
    {"source":2,"target":0,"value":8},
    {"source":3,"target":0,"value":10},
    {"source":3,"target":2,"value":6},
    {"source":4,"target":0,"value":1},
    {"source":5,"target":0,"value":1},
    {"source":6,"target":0,"value":1},
    {"source":7,"target":0,"value":1},
    {"source":8,"target":0,"value":2},
    {"source":9,"target":0,"value":1},
    {"source":11,"target":10,"value":1},
    {"source":11,"target":3,"value":3},
    {"source":11,"target":2,"value":3},
    {"source":11,"target":0,"value":5},
    {"source":12,"target":11,"value":1},
    {"source":13,"target":11,"value":1},
    {"source":14,"target":11,"value":1},
    {"source":15,"target":11,"value":1},
    {"source":17,"target":16,"value":4},
    {"source":18,"target":16,"value":4},
    {"source":18,"target":17,"value":4},
    {"source":19,"target":16,"value":4},
    {"source":19,"target":17,"value":4},
    {"source":19,"target":18,"value":4},
    {"source":20,"target":16,"value":3},
    {"source":20,"target":17,"value":3},
    {"source":20,"target":18,"value":3},
    {"source":20,"target":19,"value":4},
    {"source":21,"target":16,"value":3},
    {"source":21,"target":17,"value":3},
    {"source":21,"target":18,"value":3},
    {"source":21,"target":19,"value":3},
    {"source":21,"target":20,"value":5},
    {"source":22,"target":16,"value":3},
    {"source":22,"target":17,"value":3},
    {"source":22,"target":18,"value":3},
    {"source":22,"target":19,"value":3},
    {"source":22,"target":20,"value":4},
    {"source":22,"target":21,"value":4},
    {"source":23,"target":16,"value":3},
    {"source":23,"target":17,"value":3},
    {"source":23,"target":18,"value":3},
    {"source":23,"target":19,"value":3},
    {"source":23,"target":20,"value":4},
    {"source":23,"target":21,"value":4},
    {"source":23,"target":22,"value":4},
    {"source":23,"target":12,"value":2},
    {"source":23,"target":11,"value":9},
    {"source":24,"target":23,"value":2},
    {"source":24,"target":11,"value":7},
    {"source":25,"target":24,"value":13},
    {"source":25,"target":23,"value":1},
    {"source":25,"target":11,"value":12},
    {"source":26,"target":24,"value":4},
    {"source":26,"target":11,"value":31},
    {"source":26,"target":16,"value":1},
    {"source":26,"target":25,"value":1},
    {"source":27,"target":11,"value":17},
    {"source":27,"target":23,"value":5},
    {"source":27,"target":25,"value":5},
    {"source":27,"target":24,"value":1},
    {"source":27,"target":26,"value":1},
    {"source":28,"target":11,"value":8},
    {"source":28,"target":27,"value":1},
    {"source":29,"target":23,"value":1},
    {"source":29,"target":27,"value":1},
    {"source":29,"target":11,"value":2},
    {"source":30,"target":23,"value":1},
    {"source":31,"target":30,"value":2},
    {"source":31,"target":11,"value":3},
    {"source":31,"target":23,"value":2},
    {"source":31,"target":27,"value":1},
    {"source":32,"target":11,"value":1},
    {"source":33,"target":11,"value":2},
    {"source":33,"target":27,"value":1},
    {"source":34,"target":11,"value":3},
    {"source":34,"target":29,"value":2},
    {"source":35,"target":11,"value":3},
    {"source":35,"target":34,"value":3},
    {"source":35,"target":29,"value":2},
    {"source":36,"target":34,"value":2},
    {"source":36,"target":35,"value":2},
    {"source":36,"target":11,"value":2},
    {"source":36,"target":29,"value":1},
    {"source":37,"target":34,"value":2},
    {"source":37,"target":35,"value":2},
    {"source":37,"target":36,"value":2},
    {"source":37,"target":11,"value":2},
    {"source":37,"target":29,"value":1},
    {"source":38,"target":34,"value":2},
    {"source":38,"target":35,"value":2},
    {"source":38,"target":36,"value":2},
    {"source":38,"target":37,"value":2},
    {"source":38,"target":11,"value":2},
    {"source":38,"target":29,"value":1},
    {"source":39,"target":25,"value":1},
    {"source":40,"target":25,"value":1},
    {"source":41,"target":24,"value":2},
    {"source":41,"target":25,"value":3},
    {"source":42,"target":41,"value":2},
    {"source":42,"target":25,"value":2},
    {"source":42,"target":24,"value":1},
    {"source":43,"target":11,"value":3},
    {"source":43,"target":26,"value":1},
    {"source":43,"target":27,"value":1},
    {"source":44,"target":28,"value":3},
    {"source":44,"target":11,"value":1},
    {"source":45,"target":28,"value":2},
    {"source":47,"target":46,"value":1},
    {"source":48,"target":47,"value":2},
    {"source":48,"target":25,"value":1},
    {"source":48,"target":27,"value":1},
    {"source":48,"target":11,"value":1},
    {"source":49,"target":26,"value":3},
    {"source":49,"target":11,"value":2},
    {"source":50,"target":49,"value":1},
    {"source":50,"target":24,"value":1},
    {"source":51,"target":49,"value":9},
    {"source":51,"target":26,"value":2},
    {"source":51,"target":11,"value":2},
    {"source":52,"target":51,"value":1},
    {"source":52,"target":39,"value":1},
    {"source":53,"target":51,"value":1},
    {"source":54,"target":51,"value":2},
    {"source":54,"target":49,"value":1},
    {"source":54,"target":26,"value":1},
    {"source":55,"target":51,"value":6},
    {"source":55,"target":49,"value":12},
    {"source":55,"target":39,"value":1},
    {"source":55,"target":54,"value":1},
    {"source":55,"target":26,"value":21},
    {"source":55,"target":11,"value":19},
    {"source":55,"target":16,"value":1},
    {"source":55,"target":25,"value":2},
    {"source":55,"target":41,"value":5},
    {"source":55,"target":48,"value":4},
    {"source":56,"target":49,"value":1},
    {"source":56,"target":55,"value":1},
    {"source":57,"target":55,"value":1},
    {"source":57,"target":41,"value":1},
    {"source":57,"target":48,"value":1},
    {"source":58,"target":55,"value":7},
    {"source":58,"target":48,"value":7},
    {"source":58,"target":27,"value":6},
    {"source":58,"target":57,"value":1},
    {"source":58,"target":11,"value":4},
    {"source":59,"target":58,"value":15},
    {"source":59,"target":55,"value":5},
    {"source":59,"target":48,"value":6},
    {"source":59,"target":57,"value":2},
    {"source":60,"target":48,"value":1},
    {"source":60,"target":58,"value":4},
    {"source":60,"target":59,"value":2},
    {"source":61,"target":48,"value":2},
    {"source":61,"target":58,"value":6},
    {"source":61,"target":60,"value":2},
    {"source":61,"target":59,"value":5},
    {"source":61,"target":57,"value":1},
    {"source":61,"target":55,"value":1},
    {"source":62,"target":55,"value":9},
    {"source":62,"target":58,"value":17},
    {"source":62,"target":59,"value":13},
    {"source":62,"target":48,"value":7},
    {"source":62,"target":57,"value":2},
    {"source":62,"target":41,"value":1},
    {"source":62,"target":61,"value":6},
    {"source":62,"target":60,"value":3},
    {"source":63,"target":59,"value":5},
    {"source":63,"target":48,"value":5},
    {"source":63,"target":62,"value":6},
    {"source":63,"target":57,"value":2},
    {"source":63,"target":58,"value":4},
    {"source":63,"target":61,"value":3},
    {"source":63,"target":60,"value":2},
    {"source":63,"target":55,"value":1},
    {"source":64,"target":55,"value":5},
    {"source":64,"target":62,"value":12},
    {"source":64,"target":48,"value":5},
    {"source":64,"target":63,"value":4},
    {"source":64,"target":58,"value":10},
    {"source":64,"target":61,"value":6},
    {"source":64,"target":60,"value":2},
    {"source":64,"target":59,"value":9},
    {"source":64,"target":57,"value":1},
    {"source":64,"target":11,"value":1},
    {"source":65,"target":63,"value":5},
    {"source":65,"target":64,"value":7},
    {"source":65,"target":48,"value":3},
    {"source":65,"target":62,"value":5},
    {"source":65,"target":58,"value":5},
    {"source":65,"target":61,"value":5},
    {"source":65,"target":60,"value":2},
    {"source":65,"target":59,"value":5},
    {"source":65,"target":57,"value":1},
    {"source":65,"target":55,"value":2},
    {"source":66,"target":64,"value":3},
    {"source":66,"target":58,"value":3},
    {"source":66,"target":59,"value":1},
    {"source":66,"target":62,"value":2},
    {"source":66,"target":65,"value":2},
    {"source":66,"target":48,"value":1},
    {"source":66,"target":63,"value":1},
    {"source":66,"target":61,"value":1},
    {"source":66,"target":60,"value":1},
    {"source":67,"target":57,"value":3},
    {"source":68,"target":25,"value":5},
    {"source":68,"target":11,"value":1},
    {"source":68,"target":24,"value":1},
    {"source":68,"target":27,"value":1},
    {"source":68,"target":48,"value":1},
    {"source":68,"target":41,"value":1},
    {"source":69,"target":25,"value":6},
    {"source":69,"target":68,"value":6},
    {"source":69,"target":11,"value":1},
    {"source":69,"target":24,"value":1},
    {"source":69,"target":27,"value":2},
    {"source":69,"target":48,"value":1},
    {"source":69,"target":41,"value":1},
    {"source":70,"target":25,"value":4},
    {"source":70,"target":69,"value":4},
    {"source":70,"target":68,"value":4},
    {"source":70,"target":11,"value":1},
    {"source":70,"target":24,"value":1},
    {"source":70,"target":27,"value":1},
    {"source":70,"target":41,"value":1},
    {"source":70,"target":58,"value":1},
    {"source":71,"target":27,"value":1},
    {"source":71,"target":69,"value":2},
    {"source":71,"target":68,"value":2},
    {"source":71,"target":70,"value":2},
    {"source":71,"target":11,"value":1},
    {"source":71,"target":48,"value":1},
    {"source":71,"target":41,"value":1},
    {"source":71,"target":25,"value":1},
    {"source":72,"target":26,"value":2},
    {"source":72,"target":27,"value":1},
    {"source":72,"target":11,"value":1},
    {"source":73,"target":48,"value":2},
    {"source":74,"target":48,"value":2},
    {"source":74,"target":73,"value":3},
    {"source":75,"target":69,"value":3},
    {"source":75,"target":68,"value":3},
    {"source":75,"target":25,"value":3},
    {"source":75,"target":48,"value":1},
    {"source":75,"target":41,"value":1},
    {"source":75,"target":70,"value":1},
    {"source":75,"target":71,"value":1},
    {"source":76,"target":64,"value":1},
    {"source":76,"target":65,"value":1},
    {"source":76,"target":66,"value":1},
    {"source":76,"target":63,"value":1},
    {"source":76,"target":62,"value":1},
    {"source":76,"target":48,"value":1},
    {"source":76,"target":58,"value":1}
  ]
}
    """)

    Ok(json)
  }
}
