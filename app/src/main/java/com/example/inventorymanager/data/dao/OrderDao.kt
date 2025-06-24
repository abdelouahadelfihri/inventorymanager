package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.repository.Orders
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Query("SELECT * FROM $ORDER_TABLE ORDER BY orderId ASC")
    fun getOrders(): Flow<Orders>

    @Query("SELECT * FROM $ORDER_TABLE WHERE orderId = :id")
    suspend fun getOrder(id: Int): Order

    @Insert(onConflict = IGNORE)
    suspend fun addOrder(order: Order)

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(id: Int)

}