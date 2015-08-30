package models

//for DB connection
import play.api.Play.current
import play.api.db.DB

//for anorm sql usage
import anorm._
import anorm.SqlParser._


object ContentModel{
  case class myContent(id: Long, experiment_id: Long, name: String, html: String)

  val contentParser: RowParser[myContent] = {
    get[Long]("id") ~
    get[Long]("experiment_id") ~
    get[String]("name") ~
    get[String]("html") map {
      case id ~ experiment_id ~ name ~ html =>
        myContent(id, experiment_id, name, html)
    }
  }

  val contentsParser: ResultSetParser[List[myContent]] = {
    contentParser *
  }

  def getContentList(exp_id: Long): List[myContent] = DB.withConnection {
    implicit connection =>
    val sql = SQL("select * from content where experiment_id = {exp_id} order by id desc").on(
      "exp_id" -> exp_id)
    sql.as(contentsParser)
  }


  //insert into database
  def insertCon(content: myContent): Boolean = DB.withConnection{
    implicit connection =>
    val addedRows = SQL("""insert into content(experiment_id, name, html)
              values({exp_id}, {name}, {html})""").on(
                "exp_id" -> content.experiment_id,
                "name" -> content.name,
                "html" -> content.html
    ).executeUpdate()
    addedRows == 1
  }
  //update the database
  def updateCon(content: myContent): Boolean = DB.withConnection{
    implicit connection =>
    val updatedRows = SQL("""update content set name = {name},
                  html = {html}
                  where id = {id}""").on(
                    "id" -> content.id,
                    "name" -> content.name,
                    "html" -> content.html
    ).executeUpdate()
    updatedRows == 1
  }

  // delete from the database
  def deleteCon(content: myContent): Boolean = DB.withConnection{
    implicit connection =>
    val updatedRows = SQL("delete from content where id = {id}").on(
      "id" -> content.id
    ).executeUpdate()
    updatedRows == 0
  }

}
