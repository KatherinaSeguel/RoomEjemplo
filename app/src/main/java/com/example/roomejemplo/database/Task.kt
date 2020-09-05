package com.example.roomejemplo.database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="table_name")
data class Task (
                 @PrimaryKey(autoGenerate = true)
                 @NonNull
                 var id:Int,
                 val task:String,
                 val completeTask:Boolean)