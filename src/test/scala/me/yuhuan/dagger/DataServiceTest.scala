package me.yuhuan.dagger

import me.yuhuan.dagger
import sun.awt.image.SunWritableRaster.DataStealer

import scala.concurrent._
import scala.concurrent.duration.Duration

/**
  * Created by Yuhuan Jiang on 4/14/17.
  */
object DataServiceTest extends App {
  
  val taskId = 3
  
  val subtaskIds = await { DataService.subtaskIdsOf(taskId) }
  val subtasks = await { DataService.subtasksOf(taskId) }
  
  val supertaskIds = await { DataService.supertaskIdsOf(taskId) }
  val supertasks = await { DataService.supertasksOf(taskId) }
  

  
  val bp = 0
  
  def await[T](a: => Awaitable[T]) = {
    Await.result(a, Duration.Inf)
  }
  

}
