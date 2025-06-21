package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventorymanager.core.Constants.Companion.ORDER_DETAILS_TABLE
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.model.Order
import com.example.inventorymanager.domain.model.OrderDetails

import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderDetails: OrderDetails)

    @Update
    suspend fun update(orderDetails: OrderDetails)

    @Delete
    suspend fun delete(orderId: Int, productId: Int, warehouseId: Int)

    @Query("SELECT * FROM $ORDER_DETAILS_TABLE WHERE orderId = :orderId AND productId = :productId AND warehouseId = :warehouseId LIMIT 1")
    suspend fun getByIds(orderId: Int, productId: Int, warehouseId: Int): OrderDetails?

    @Query("SELECT * FROM $ORDER_DETAILS_TABLE")
    fun getAll(): Flow<List<OrderDetails>>
}