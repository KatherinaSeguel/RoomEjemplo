package com.example.roomejemplo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomejemplo.database.Task

@Dao
interface TaskDao {
//estas funciones retornan datos, está utilizando suspend
    @Insert (onConflict = OnConflictStrategy.REPLACE)  //Insertar 1 objeto en la tabla, REEMPLAZA SI O SI EN CASO DE CONFLICTO
   suspend fun insertOneTask(mtask: Task)  //recibe el objeto el desglose de los atributos los hace Room


    @Insert(onConflict = OnConflictStrategy.REPLACE) //en caso de conflicto REEMPLAZA
    fun insertMultipleTask(mlistTask:List<Task>) //insertar multiples objetos tabla


    @Update
    fun updateOneTask(mtask: Task) // modificar

    @Delete
    fun deleteOneTask(mtask: Task)// eliminar

    @Query("SELECT * FROM table_name")  //devuelve todos los datos envuelto el LiveData
    fun getAllTaskFromDb(): LiveData<List<Task>> //se envuelve el LIST en LiveData

    @Query("SELECT * FROM table_name WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneTaskByID(mid:Int): LiveData<Task> //yo le paso un id y la cuery me trae el Task u objeto que encuentre

 @Query ("Delete FROM table_name")
 suspend fun deleteALLTask()

}