package com.example.roomejemplo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomejemplo.database.Task
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {
lateinit var  mViewModel: TaskViewModel
private var idTask:Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(TaskViewModel::class.java)
        arguments?.let {
            idTask = it.getInt("id")
            Log.d("OBJ",idTask.toString())
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idTask?.let {
            mViewModel.getOneTaskByID(it).observe(viewLifecycleOwner, Observer {
                Log.d("OBJ_LIVE",it.task)

                editTexTask.setText(it.task)
                checkBox.isChecked = it.completeTask

            })
        } //envolvio con la ampolleta roja y salió el let

        saveBtn.setOnClickListener {

            val textTast = editTexTask.text.toString()
            val checkBox= checkBox.isChecked

            if (textTast.isNotEmpty()) {  //si es que no está vacio
            if (idTask != null) {
                Log.d("OBJ_ID_TASK", idTask.toString())
                val mTask = Task(task= textTast, completeTask = checkBox,id= idTask!!)
                mViewModel.updateTask(mTask)

            }else{

                val mTask = Task(task = textTast, completeTask = checkBox)
                mViewModel.insertTask(mTask)
            }}
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }}
             }

