package com.example.inventorymanager.data.dao.ingoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.repository.Orders
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDao {

    @Query("SELECT * FROM ${Constants.Companion.ORDER_TABLE} ORDER BY orderId ASC")
    fun getOrders(): Flow<Orders>

    @Query("SELECT * FROM ${Constants.Companion.ORDER_TABLE} WHERE orderId = :id")
    suspend fun getOrder(id: Int): Order

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addOrder(order: Order)

    @Update
    suspend fun updateOrder(order: Order)

    @Delete
    suspend fun deleteOrder(id: Int)

}