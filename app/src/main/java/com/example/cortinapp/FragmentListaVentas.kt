package com.example.cortinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.cortinapp.room_database.AlmacenDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

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

            val room : AlmacenDatabase = Room.databaseBuilder(context?.applicationContext!!,
            AlmacenDatabase::class.java,"AlmacenDatabase").build()
            var ventaDao = room.ventaDao()
            runBlocking {
                launch {
                    var result = ventaDao.getAllSales()
                    for (venta in result){
                        datos.add(Task(venta.Id, venta.FechaVenta, venta.CedulaVendedor, venta.CedulaCliente, venta.NombreCliente, venta.Direccion, venta.Latitud, venta.Longitud, venta.TipoCortina, venta.Ancho, venta.Alto, venta.AreaTotal, venta.Precio, venta.CuotaSemanal, venta.Saldo ))
                    }

                }
            }
            //datos.add(Task(1, "11-20-2020","Pedro Perez","Pepito Perez", "112233","Calle55",10,15,1,20,80,160,300000,50000,250000 ))
            //datos.add(Task(2, "04-18-2018","Perenguita piñerez","Fulanito de tal","547621","Mz 8",8,5,2,40,100,400,1000000,100000,900000 ))
            //datos.add(Task(3, "09-02-2019","Pablo Osea","Jonny Zee","4557","Lt 88",50,25,3,70,120,300,700000,30000,670000))
            //datos.add(Task(4, "13-01-2021","Cleo Sepa","Maria Medrano", "154122","Calle 6",15,30,4,60,60,120,850000,50000,800000 ))
            var taskAdapter = TaskAdapter(datos){
                val datos = Bundle()
                datos.putInt("id", it.Id)

/*                datos.putString("Codigo", it.Id.toString())
                datos.putString("Fecha",it.fechaVenta)
                datos.putString("Vendedor",it.Vendedor)
                datos.putString("Cliente", it.Cliente)
                datos.putString("Cedula", it.Cedula)
                datos.putString("Direccion", it.Direccion)
                datos.putString("Latitud", it.Latitud.toString())
                datos.putString("Longitud", it.Longitud.toString())
                datos.putString("IdCortina", it.idCortina.toString())
                datos.putString("Ancho", it.ancho.toString())
                datos.putString("Alto", it.Alto.toString())
                datos.putString("Area", it.Area.toString())
                datos.putString("Precio", it.Precio.toString())
                datos.putString("Cuota", it.Cuota.toString())
                datos.putString("Saldo", it.Saldo.toString())*/


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