package com.example.roomejemplo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomejemplo.database.Task
import com.example.roomejemplo.database.TaskDatabase
import kotlinx.coroutines.launch

class TaskViewModel (application: Application) : AndroidViewModel(application) { //se colocó application porque necesita ese contexto
    private val repository: TaskRepository
    val allTask: LiveData<List<Task>>
    init {
         val taskDao = TaskDatabase.getDatabase(application).getTaskDao()
        repository = TaskRepository(taskDao)
        allTask= repository.listAllTask
    }

    fun insertTask(task: Task)= viewModelScope.launch {
        repository.insertTask(task)
    }

    fun deleteALLTask() = viewModelScope.launch {
        repository.deleteALL()
    }
}