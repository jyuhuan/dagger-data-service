package me.yuhuan.dagger

/**
  * Created by Yuhuan Jiang on 4/14/17.
  */
import slick.driver.H2Driver.api._

class Tasks(tag: Tag) extends Table[Task](tag, "tasks") {
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey)
  def title: Rep[String] = column[String]("title")
  def body: Rep[String] = column[String]("body")
  def done: Rep[Boolean] = column[Boolean]("done")
  def userId: Rep[Int] = column[Int]("user_id", O.PrimaryKey)
  def * = (id, title, body, done, userId) <> (Task.tupled, Task.unapply)
}

class Rels(tag: Tag) extends Table[Rel](tag, "rels") {
  def pid: Rep[Int] = column[Int]("pid", O.PrimaryKey)
  def cid: Rep[Int] = column[Int]("cid", O.PrimaryKey)
  def * = (pid, cid) <> (Rel.tupled, Rel.unapply)
}

class Users(tag: Tag) extends Table[User](tag, "users") {
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey)
  def firstName: Rep[String] = column[String]("first_name")
  def lastName: Rep[String] = column[String]("last_name")
  def email: Rep[String] = column[String]("email")
  def * = (id, firstName, lastName, email) <> (User.tupled, User.unapply)
}