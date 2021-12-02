package com.example.cortinapp.room_database

import androidx.room.*

@Database(
    entities = arrayOf (Venta::class),
    version = 1
)

abstract class AlmacenDatabase: RoomDatabase() {
    abstract fun ventaDao(): VentaDAO
}