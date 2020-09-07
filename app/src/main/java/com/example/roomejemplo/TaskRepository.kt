package com.example.roomejemplo

import androidx.lifecycle.LiveData
import com.example.roomejemplo.database.Task
import com.example.roomejemplo.database.TaskDao

class TaskRepository(private val mTaskDao:TaskDao) {       //instancia el Dao, la interface

    val listAllTask:LiveData<List<Task>> = mTaskDao.getAllTaskFromDb() //estoy creando la variable,contendrá todos datos DB

   suspend fun insertTask(mTask:Task) {
        mTaskDao.insertOneTask(mTask) //llama a la  función del Dao, Inserta información
            }

}