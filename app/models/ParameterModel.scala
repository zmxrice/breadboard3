package models

//for DB connection
import play.api.Play.current
import play.api.db.DB

//for anorm sql usage
import anorm._
import anorm.SqlParser._


object ParameterModel{
  case class Parameter(id: Long, experiment_id: Long, name: String,
      val_type: Option[String], min_val: Option[String],
      max_val: Option[String], default_val: Option[String],
      description: Option[String])

  val parameterParser: RowParser[Parameter] = {
    get[Long]("id") ~
    get[Long]("experiment_id") ~
    get[String]("name") ~
    get[Option[String]]("type") ~
    get[Option[String]]("min_val") ~
    get[Option[String]]("max_val") ~
    get[Option[String]]("default_val") ~
    get[Option[String]]("description") map {
      case id ~ experiment_id ~ name ~ val_type ~ min_val ~ max_val ~ default_val ~ description =>
        Parameter(id, experiment_id, name, val_type, min_val, max_val, default_val, description)
    }
  }

  val parametersParser: ResultSetParser[List[Parameter]] = {
    parameterParser *
  }

  def getParamList(exp_id: Long): List[Parameter] = DB.withConnection {
    implicit connection =>
    val sql = SQL("select * from parameters where experiment_id = {exp_id} order by id desc").on(
      "exp_id" -> exp_id)
    sql.as(parametersParser)
  }


  //insert into database
  def insertParam(parameter: Parameter): Boolean = DB.withConnection{
    implicit connection =>
    val addedRows = SQL("""insert into parameters(experiment_id,
              name, type, min_val, max_val, default_val, description)
              values({exp_id}, {name}, {val_type}, {min_val},
              {max_val}, {default_val},
              {description})""").on(
                "exp_id" -> parameter.experiment_id,
                "name" -> parameter.name,
                "val_type" -> parameter.val_type,
                "min_val" -> parameter.min_val,
                "max_val" -> parameter.max_val,
                "default_val" -> parameter.default_val,
                "description" -> parameter.description
    ).executeUpdate()
    addedRows == 1
  }
  //update the database
  def updateParam(parameter: Parameter): Boolean = DB.withConnection{
    implicit connection =>
    val updatedRows = SQL("""update parameters set name = {name},
                  type = {val_type}, min_val = {min_val},
                  max_val = {max_val}, default_val = {default_val},
                  description = {description}
                  where id = {id}""").on(
                    "id" -> parameter.id,
                    "name" -> parameter.name,
                    "val_type" -> parameter.val_type,
                    "min_val" -> parameter.min_val,
                    "max_val" -> parameter.max_val,
                    "default_val" -> parameter.default_val,
                    "description" -> parameter.description
    ).executeUpdate()
    updatedRows == 1
  }

  // delete from the database
  def deleteParam(parameter: Parameter): Boolean = DB.withConnection{
    implicit connection =>
    val updatedRows = SQL("delete from parameters where id = {id}").on(
      "id" -> parameter.id
    ).executeUpdate()
    updatedRows == 0
  }

}
