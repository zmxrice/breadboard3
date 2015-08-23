package controllers

import play.api._
import play.api.mvc._
import models._

import play.api.libs.json._
import org.json4s._
import org.json4s.jackson.Serialization
import org.json4s.jackson.Serialization.{read, write}

import scala.collection.mutable.Map
import scala.collection.mutable.ArrayBuffer

import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

object GraphGenerator extends Controller{
  def randomGraph = Action{
    /*implicit val formats = Serialization.formats(NoTypeHints)
    def G = Graph
    G.addVertices(10)
    G.random
    //val g = G.E
    val vertexMap = G.V
    //val json = convertEdgeToJson(g)
    val vertex = Map[String, String]()
    val arr = ArrayBuffer[String]()
    vertexMap.foreach{case(key, value) => vertex += ("name" -> value.toString)}
    vertex.foreach{case(key, value) => println(key + value)}

    val json = (
      "nodes" ->
          vertexMap.map{ case(key, value) =>
            ("name" -> value)
          }
    )
    G.empty
    //Ok(views.html.graph(Serialization.write(g)))
    //Ok(views.html.graph(Json.stringify(json)))
    Ok(views.html.graph(pretty(render(json))))*/
    Ok(views.html.graph("test"))
  }

}
