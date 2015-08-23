package models

//for DB connection
import play.api.Play.current
import play.api.db.DB

//for anorm sql usage
import anorm.SQL
import anorm.SqlQuery

//for parser
import anorm.RowParser
import anorm.~
import anorm.SqlParser._
import anorm.ResultSetParser

object ExperimentModel{
  case class Experiment(id: Long, name: String, style: String,
      qualification_type_id: Option[String], qualification_type_id_sandbox: Option[String])

  // read from the database
  val experimentParser: RowParser[Experiment] = {
    long("id") ~
    str("name") ~
    str("style") ~
    get[Option[String]]("qualification_type_id") ~
    get[Option[String]]("qualification_type_id_sandbox") map {
      case id ~ name ~ style ~ qualification_type_id ~ qualification_type_id_sandbox =>
        Experiment(id, name, style, qualification_type_id, qualification_type_id_sandbox)
    }
  }

  val experimentsParser: ResultSetParser[List[Experiment]] = {
    experimentParser *
  }

  def getAnotherExpList: List[Experiment] = DB.withConnection {
    implicit connection =>
    val sql: SqlQuery = SQL("select * from experiments order by id asc")
    sql.as(experimentsParser)
  }

  //insert into database
  def insertExp(experiment: Experiment): Boolean = DB.withConnection{
    implicit connection =>
    val addedRows = SQL("""insert into experiments values({id}, {name},
              {style}, {qualification_type_id},
              {qualification_type_id_sandbox})""").on(
                "id" -> experiment.id,
                "name" -> experiment.name,
                "style" -> experiment.style,
                "qualification_type_id" -> experiment.qualification_type_id,
                "qualification_type_id_sandbox" -> experiment.qualification_type_id_sandbox
    ).executeUpdate()
    addedRows == 1
  }
  //update the database
  def updateExp(experiment: Experiment): Boolean = DB.withConnection{
    implicit connection =>
    val updatedRows = SQL("""update experiments set name = {name},
                  style = {style},
                  qualification_type_id = {qualification_type_id},
                  qualification_type_id_sandbox = {qualification_type_id_sandbox}
                  where id = {id}""").on(
                    "id" -> experiment.id,
                    "name" -> experiment.name,
                    "style" -> experiment.style,
                    "qualification_type_id" -> experiment.qualification_type_id,
                    "qualification_type_id_sandbox" -> experiment.qualification_type_id_sandbox
    ).executeUpdate()
    updatedRows == 1
  }

  // delete from the database
  def deleteExp(experiment: Experiment): Boolean = DB.withConnection{
    implicit connection =>
    val updatedRows = SQL("delete from experiments where id = {id}").on(
      "id" -> experiment.id
    ).executeUpdate()
    updatedRows == 0
  }

}
