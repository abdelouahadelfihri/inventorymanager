package com.example.inventorymanager.data.dao.outgoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.outgoings.SalesOrderLine
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDetailDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(deliveryDetails: SalesOrderLine)

    @Update
    suspend fun update(deliveryDetails: SalesOrderLine)

    @Delete
    suspend fun delete(deliveryId: Int, productId: Int, warehouseId: Int)

    @Query("SELECT * FROM ${Constants.Companion.DELIVERY_DETAILS_TABLE} WHERE deliveryId = :deliveryId AND productId = :productId AND warehouseId = :warehouseId LIMIT 1")
    suspend fun getByIds(deliveryId: Int, productId: Int, warehouseId: Int): SalesOrderLine?

    @Query("SELECT * FROM ${Constants.Companion.DELIVERY_DETAILS_TABLE}")
    fun getAll(): Flow<List<SalesOrderLine>>

}