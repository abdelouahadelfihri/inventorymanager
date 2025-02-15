package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventorymanager.domain.model.Order
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE


@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order)

    @Update
    suspend fun update(order: Order)

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM $ORDER_TABLE")
    suspend fun getOrders(): List<Order>

    @Query("SELECT * FROM $ORDER_TABLE WHERE orderId = :id")
    suspend fun getOrderById(id: Int): Order?
}
