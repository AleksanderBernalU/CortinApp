package com.example.cortinapp.room_database
import androidx.room.*

@Dao
interface VentaDAO {
        @Query("SELECT * FROM Venta")
        suspend fun getAllSales(): List<Venta>

        @Query("SELECT * FROM Venta WHERE id = :id")
        suspend fun findById(id: Int): Venta

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertSale(venta: Venta): Long

        @Update
        suspend fun updateSale(venta: Venta)

        @Delete
        suspend fun deleteSale(venta: Venta)
    }
