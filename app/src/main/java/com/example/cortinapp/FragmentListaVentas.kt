package com.example.cortinapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentListaVentas.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentListaVentas : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val fragmento: View = inflater.inflate(R.layout.fragment_lista_ventas, container, false)

        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val recyclerVentaList: RecyclerView = view.findViewById(R.id.recycleListaVenta)
            var datos: ArrayList<Task> = ArrayList()
            datos.add(Task(1, "Pepito Perez"))
            datos.add(Task(2, "Fulanito de tal"))
            datos.add(Task(3, "Jonny Zee"))
            datos.add(Task(4, "Armando Casas"))
            var taskAdapter = TaskAdapter(datos){
                val datos = Bundle()
                datos.putInt("Codigo", it.codigo)
                datos.putString("Hora", it.Cliente)
                /*datos.putInt("Venta Total", it.precio)*/
                Navigation.findNavController(view).navigate(R.id.nav_detail, datos)
            }
            recyclerVentaList.setHasFixedSize(true)
            recyclerVentaList.adapter = taskAdapter
            recyclerVentaList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentListaVentas.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic fun newInstance(param1: String, param2: String) =
                FragmentListaVentas().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}