package me.yuhuan.dagger

import slick.driver.MySQLDriver.api._
//import slick.driver.PostgresDriver.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Created by Yuhuan Jiang on 4/14/17.
  */
object DataService {

  val db = Database.forConfig("jDB")
  val tasks = TableQuery[Tasks]
  val rels = TableQuery[Rels]
  val users = TableQuery[Users]
  
  def getTaskById(id: Int): Future[Option[Task]] = {
    val q = tasks.filter(_.id === id)
    db.run(q.result).map(_.headOption)
  }
  
  def getUserById(id: Int): Future[Option[User]] = {
    val q = users.filter(_.id === id)
    db.run(q.result).map(_.headOption)
  }
  
  def subtaskIdsOf(taskId: Int): Future[Seq[Int]] = {
    val q = rels.filter(_.pid === taskId).map(rel => rel.cid)
    db.run(q.result)
  }
  
  def subtasksOf(taskId: Int): Future[Seq[Task]] = {
    val q = for {
      rel <- rels
      if rel.pid === taskId
      task <- tasks.filter(_.id === rel.cid)
    } yield task
    db.run(q.result)
  }
  
  def supertaskIdsOf(taskId: Int): Future[Seq[Int]] = {
    val q = rels.filter(_.cid === taskId).map(rel => rel.pid)
    db.run(q.result)
  }

  def supertasksOf(taskId: Int): Future[Seq[Task]] = {
    val q = for {
      rel <- rels
      if rel.cid === taskId
      task <- tasks.filter(_.id === rel.pid)
    } yield task
    db.run(q.result)
  }
  
  object CommonQueries {

  }
  
}
