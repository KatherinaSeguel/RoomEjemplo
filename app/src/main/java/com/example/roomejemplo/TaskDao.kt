package com.example.roomejemplo

import androidx.room.*

@Dao
interface TaskDao {
//estas funciones retornan datos
    @Insert (onConflict = OnConflictStrategy.REPLACE)  //Insertar 1 objeto en la tabla, REEMPLAZA SI O SI EN CASO DE CONFLICTO
    fun insertOneTask(mtask:Task)  //recibe el objeto el desglose de los atributos los hace Room


    @Insert(onConflict = OnConflictStrategy.REPLACE) //en caso de conflicto REEMPLAZA
    fun insertMultipleTask(mlistTask:List<Task>) //insertar multiples objetos tabla


    @Update
    fun updateOneTask(mtask: Task) // modificar

    @Delete
    fun deleteOneTask(mtask: Task)// eliminar

    @Query("SELECT * FROM table_name")
    fun getAllTaskFromDb():List<Task>

    @Query("SELECT * FROM table_name WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneTaskByID(mid:Int):Task //yo le paso un id y la cuery me trae el Task u objeto que encuentre

}