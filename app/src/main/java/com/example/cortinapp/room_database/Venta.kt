package com.example.cortinapp.room_database
import androidx.room.*

@Entity
data class Venta (
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val FechaVenta: String,
    val CedulaVendedor: String,
    val CedulaCliente: String,
    val NombreCliente: String,
    val Direccion: String,
    val Latitud: String,
    val Longitud: String,
    val TipoCortina: String,
    val Ancho: String,
    val Alto: String,
    val AreaTotal: String,
    val Precio: String,
    val CuotaSemanal: String,
    val Saldo: String
)