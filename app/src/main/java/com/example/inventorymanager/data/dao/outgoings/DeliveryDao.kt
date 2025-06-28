package com.example.inventorymanager.data.dao.outgoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.common.Customers
import com.example.inventorymanager.domain.common.Deliveries
import com.example.inventorymanager.domain.model.outgoings.Delivery
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDao {

    @Query("SELECT * FROM ${Constants.Companion.DELIVERY_TABLE} ORDER BY deliveryId ASC")
    fun getDeliveries(): Flow<Deliveries>
    @Query("SELECT * FROM ${Constants.Companion.CUSTOMER_TABLE} ORDER BY customerId ASC")
    fun getCustomers(): Flow<Customers>

    @Query("SELECT * FROM ${Constants.Companion.DELIVERY_TABLE} WHERE deliveryId = :id")
    suspend fun getDelivery(id: Int): Delivery

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addDelivery(delivery: Delivery)

    @Update
    suspend fun updateDelivery(delivery: Delivery)

    @Delete
    suspend fun deleteDelivery(id: Int)

}