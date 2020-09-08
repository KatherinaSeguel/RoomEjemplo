package com.example.roomejemplo

import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomejemplo.database.Task
import kotlinx.android.synthetic.main.task_item_list.view.*

class TaskAdapter () : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


  private var dataList = emptyList<Task>()
//función que actualiza el listado del adapter
    fun updateDataList(mDataList: List<Task>){
       dataList=mDataList
        notifyDataSetChanged() //el grita que hay cambios para que se actualicen los datos
      }

//ViewHolder
    inner class  TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val taskText = itemView.taskTv
        val checkTask = itemView.checkBox
        val idText= itemView.idView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item_list,parent,false)
        return TaskViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val mTask: Task=dataList[position]  //rescata 1 objeto por posicion
        holder.taskText.text=mTask.task
        holder.checkTask.isChecked=mTask.completeTask
        holder.idText.text=mTask.id.toString()

    }

    override fun getItemCount(): Int {
        return dataList.size
    }




}