package com.example.roomejemplo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext
private const val DATA_BASE_NAME="task_db"

@Database(entities = [Task::class],version=1)//entities y version lo escribo yo
abstract class TaskDatabase: RoomDatabase(){ //RoomDatabase lo escribo yo

    abstract fun getTaskDao():TaskDao //aquí va la interface

    companion object{ //método estatico , no nesecito una referencia del objeto para ocuparlo

        @Volatile
        private  var INSTANCE:TaskDatabase?=null

        fun getDatabase(context: Context): TaskDatabase{
            val tempInstance= INSTANCE
             if(tempInstance!=null){
                 return tempInstance
             }
            synchronized(this){
                val instance=Room.databaseBuilder(context,TaskDatabase::class.java,DATA_BASE_NAME).build()
                INSTANCE= instance
                return instance
            }
        }

    }
}