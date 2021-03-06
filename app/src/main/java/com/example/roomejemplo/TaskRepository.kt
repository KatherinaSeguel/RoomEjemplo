package com.example.roomejemplo

import androidx.lifecycle.LiveData
import com.example.roomejemplo.database.Task
import com.example.roomejemplo.database.TaskDao
//instancia el Dao, la interface
class TaskRepository(private val mTaskDao:TaskDao) {

    val listAllTask:LiveData<List<Task>> = mTaskDao.getAllTaskFromDb() //estoy creando la variable,contendrá todos datos DB

   suspend fun insertTask(mTask:Task) {
        mTaskDao.insertOneTask(mTask) //llama a la  función del Dao, Inserta información
            }


    //esta función delete all

    suspend fun deleteALL(){
        mTaskDao.deleteALLTask()
    }

//va al DAO y trae el objeto encontrado por ID envuelto en LiveData

    fun getOneTaskByID(id : Int): LiveData<Task>{
       return  mTaskDao.getOneTaskByID(id)
    }
//este realiza el update
    suspend fun updateTask(mtask: Task){
        mTaskDao.updateOneTask(mtask)
    }

}