package com.example.cortinapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [fragment_detail.newInstance] factory method to
 * create an instance of this fragment.
 */
class fragment_detail : Fragment() {
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

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento =inflater.inflate(R.layout.fragment_detail, container, false)
        var codigo = requireArguments().getString("Codigo")
        var fecha = requireArguments().getString("Fecha")
        var vendedor = requireArguments().getString("Vendedor")
        var cliente = requireArguments().getString("Cliente")
        var cedula = requireArguments().getString("Cedula")
        var direccion = requireArguments().getString("Direccion")
        var latitud = requireArguments().getString("Latitud")
        var longitud = requireArguments().getString("Longitud")
        var idCortina = requireArguments().getString("IdCortina")
        var ancho = requireArguments().getString("Ancho")
        var alto = requireArguments().getString("Alto")
        var area = requireArguments().getString("Area")
        var precio = requireArguments().getString("Precio")
        var cuota = requireArguments().getString("Cuota")
        var saldo = requireArguments().getString("Saldo")

        val textViewCodigo: TextView = fragmento.findViewById(R.id.textViewCodigo)
        val textViewFecha: TextView = fragmento.findViewById(R.id.textViewFecha)
        val textViewVendedor: TextView = fragmento.findViewById(R.id.textViewVendedor)
        val textViewCliente: TextView = fragmento.findViewById(R.id.textViewCliente)
        val textViewCedula: TextView = fragmento.findViewById(R.id.textViewCedula)
        val textViewDireccion: TextView = fragmento.findViewById(R.id.textViewDireccion)
        val textViewLatitud: TextView = fragmento.findViewById(R.id.textViewLatitud)
        val textViewLongitud: TextView = fragmento.findViewById(R.id.textViewLongitud)
        val textViewIdCortina: TextView = fragmento.findViewById(R.id.textViewIdCortina)
        val textViewAncho: TextView = fragmento.findViewById(R.id.textViewAncho)
        val textViewAlto: TextView = fragmento.findViewById(R.id.textViewAlto)
        val textViewArea: TextView = fragmento.findViewById(R.id.textViewArea)
        val textViewPrecio: TextView = fragmento.findViewById(R.id.textViewPrecio)
        val textViewCuota: TextView = fragmento.findViewById(R.id.textViewCuota)
        val textViewSaldo: TextView = fragmento.findViewById(R.id.textViewSaldo)

        textViewCodigo.text = codigo
        textViewFecha.text = fecha
        textViewVendedor.text = vendedor
        textViewCliente.text = cliente
        textViewCedula.text = cedula
        textViewDireccion.text = direccion
        textViewLatitud.text = latitud
        textViewLongitud.text = longitud
        textViewIdCortina.text = idCortina
        textViewAncho.text = ancho
        textViewAlto.text = alto
        textViewArea.text = area
        textViewPrecio.text = precio
        textViewCuota.text = cuota
        textViewSaldo.text = saldo
        return fragmento
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment fragment_detail.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            fragment_detail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}