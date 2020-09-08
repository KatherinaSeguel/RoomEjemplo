package com.example.roomejemplo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomejemplo.database.Task
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

//se genera con el menú codigo generate metodo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel= ViewModelProvider(this).get(TaskViewModel::class.java)
    }

    lateinit var viewModel: TaskViewModel
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {



       return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment

     /*  val task=Task(0,"Algo de prueba",false)
       val task1=Task(1,"Algo de prueba 1",false)
      val task2=Task(2,"Algo de prueba 2",false)


     viewModel.insertTask(task) //ingresa BD
      viewModel.insertTask(task1)
      viewModel.insertTask(task2)*/


      //  viewModel.deleteALLTask()//elimina los elementos de a base de datos
        //escuchar el Live Data del viewModel
//se autogenera
        //instancia reciclerView
        //instancia el objeto de la clase Adapter

        val mRecyclerView = recyclerView  //funciona por sintetic
        val madapter =TaskAdapter()
       mRecyclerView.adapter=madapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.allTask.observe(viewLifecycleOwner, Observer {
            Log.d ("OBJETO",it.toString())

            madapter.updateDataList(it)
        })

    }
}