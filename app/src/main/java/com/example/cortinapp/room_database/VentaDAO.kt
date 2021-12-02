package com.example.cortinapp.room_database

import androidx.room.*

@Dao
interface VentaDAO {

    @Query("SELECT * FROM Venta")
    suspend fun getAllSales(): List<Venta>

    @Query("SELECT * FROM Venta WHERE Id= :id")
    suspend fun findById(id: Int): Venta

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSale(vender: Venta): Long

    @Update
    suspend fun updateSale(vender: Venta)

    @Delete
    suspend fun deleteSale (vender: Venta)
}
