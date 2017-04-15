package me.yuhuan.dagger

/**
  * Created by Yuhuan Jiang on 4/14/17.
  */

/**
  * Represents a task. 
  * 
  * @param id The unique identifier of this task. 
  * @param title The title of this task. 
  *              Typically, this would be a short description of the task.  
  * @param body The detailed content of this task in the Markdown format.
  * @param isDone Is the task done. 
  * @param userId The ID of the user who created this task. 
  */
case class Task(id: Int, title: String, body: String, isDone: Boolean, userId: Int)
