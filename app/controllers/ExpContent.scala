package controllers

import play.api._
import play.api.mvc._
import models.ContentModel._

import play.api.libs.json._
// read json request
import play.api.libs.functional.syntax._

object ExpContent extends Controller {
  def getContent(exp_id: Long) = Action {
    implicit val contentWrites = Json.writes[myContent]
    val contents: List[myContent] = getContentList(exp_id)
    Ok(Json.toJson(contents))
  }

  implicit val contentReads: Reads[myContent] = (
    (JsPath \ "id").read[Long] and
    (JsPath \ "experiment_id").read[Long] and
    (JsPath \ "name").read[String] and
    (JsPath \ "html").read[String]
  )(myContent.apply _)

  def addContent = Action(parse.json) { request =>
    val contentJson = request.body
    val content = contentJson.as[myContent]
    try{
      insertCon(content)
      Ok("content Insert Saved")
    }
    catch{
      case e =>
      Ok(e.toString())
    }
  }

  def updateContent = Action(parse.json) { request =>
    val contentJson = request.body
    val content = contentJson.as[myContent]
    try{
      updateCon(content)
      Ok("content update Saved")
    }
    catch{
      case e:IllegalArgumentException =>
      BadRequest("content not updated")
    }
  }

  def deleteContent = Action(parse.json) { request =>
    val contentJson = request.body
    val content = contentJson.as[myContent]
    try{
      deleteCon(content)
      Ok("content deletion Saved")
    }
    catch{
      case e =>
      Ok(e.toString())
    }
  }
}
