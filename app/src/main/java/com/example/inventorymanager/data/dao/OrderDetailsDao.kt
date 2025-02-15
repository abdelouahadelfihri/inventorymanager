package com.example.inventory.data.dao

import androidx.room.*
import com.example.inventory.domain.model.OrderDetails
import com.example.inventorymanager.core.Constants.Companion.ORDER_DETAILS_TABLE
import com.example.inventorymanager.domain.model.Order


@Dao
interface OrderDetailsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderDetails: OrderDetails)

    @Update
    suspend fun update(order: Order)

    @Delete
    suspend fun delete(order: Order)

    @Query("SELECT * FROM $ORDER_DETAILS_TABLE")
    suspend fun getAll(): List<Order>

    @Query("SELECT * FROM $ORDER_DETAILS_TABLE WHERE orderId = :id")
    suspend fun getByIdS(id: Int): Order?
}