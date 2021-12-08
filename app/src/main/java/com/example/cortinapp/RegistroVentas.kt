package com.example.cortinapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.room.*
import com.example.cortinapp.room_database.AlmacenDatabase
import com.example.cortinapp.room_database.Venta
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class RegistroVentas : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmento = inflater.inflate(R.layout.activity_registro_ventas, container, false)
        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle? ) {
        super.onViewCreated(view, savedInstanceState)

        val btnRegVenta: Button = view.findViewById(R.id.btnRegVenta)
       // val TxvPrueba: TextView = view.findViewById(R.id.TxvPrueba)
        val edtDateSale: EditText = view.findViewById(R.id.edtDateSale)
        val edtSellerId: EditText = view.findViewById(R.id.edtSellerId)

        val edtClientId: EditText = view.findViewById(R.id.edtClientId)
        val edtCientName: EditText = view.findViewById(R.id.edtCientName)
        val edtClientAddress: EditText = view.findViewById(R.id.edtClientAddress)
        val edtLatitude: EditText = view.findViewById(R.id.edtLatitude)
        val edtLongitude: EditText = view.findViewById(R.id.edtLongitude)

        val edtCourtainId: EditText = view.findViewById(R.id.edtCourtainId)
        val edtWidth: EditText = view.findViewById(R.id.edtWidth)
        val edtHeight: EditText = view.findViewById(R.id.edtHeight)
        val edtTotalArea: EditText = view.findViewById(R.id.edtTotalArea)

        val edtPrice: EditText = view.findViewById(R.id.edtPrice)
        btnRegVenta.setOnClickListener{
//Ajuste del registro de ventas
            val precio = edtPrice.text.toString()
            val ValorCuota: Float? = precio.toFloat() / 24
            val ValorSaldo: Float? = precio.toFloat()

            val room : AlmacenDatabase = Room.databaseBuilder(context?.applicationContext!!,AlmacenDatabase::class.java,"AlmacenDatabase").build()
            var ventaDao = room.ventaDao()
            var venta = Venta(0,edtDateSale.text.toString(),edtSellerId.text.toString(),edtClientId.text.toString(),edtCientName.text.toString(),edtClientAddress.text.toString(),edtLatitude.text.toString(),edtLongitude.text.toString(),edtCourtainId.text.toString(),edtWidth.text.toString(),edtHeight.text.toString(),edtTotalArea.text.toString(),edtPrice.text.toString(),ValorCuota.toString(),ValorSaldo.toString())

            val dbFirebase = FirebaseFirestore.getInstance()
            runBlocking {
                launch {
                    var result = ventaDao.insertSale(venta)

                    if(result !=-1L)
                    {
                        dbFirebase.collection("Venta")
                            .document(result.toString())
                            .set(
                                hashMapOf(
                                    "Id" to edtDateSale.text.toString(),
                                    "FechaVenta" to edtDateSale.text.toString(),
                                    "CedulaVendedor" to edtSellerId.text.toString(),
                                    "CedulaCliente" to edtClientId.text.toString(),
                                    "NombreCliente" to edtCientName.text.toString(),
                                    "Direccion" to edtClientAddress.text.toString(),
                                    "Latitud" to edtLatitude.text.toString(),
                                    "Longitud" to edtLongitude.text.toString(),
                                    "TipoCortina" to edtCourtainId.text.toString(),
                                    "Ancho" to edtWidth.text.toString(),
                                    "Alto" to edtHeight.text.toString(),
                                    "AreaTotal" to edtTotalArea.text.toString(),
                                    "Precio" to edtPrice.text.toString(),
                                    "CuotaSemanal" to ValorCuota.toString(),
                                    "Saldo" to ValorSaldo.toString()
                                )
                            )
                    }
                    //TxvPrueba.text =result.toString()
                    //Toast.makeText(context?.applicationContext!!,""+result,Toast.LENGTH_LONG).show()
                }
            }
            Navigation.findNavController(view).navigate(R.id.nav_listaVentas)

//            TxvPrueba.text = ValorCuota.toString()
//            Toast.makeText(context?.applicationContext!!,"mensaje".toString(),Toast.LENGTH_LONG).show()
        }
    }

}