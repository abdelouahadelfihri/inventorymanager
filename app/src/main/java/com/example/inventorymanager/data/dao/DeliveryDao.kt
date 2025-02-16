package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.Delivery
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_TABLE
import com.example.inventorymanager.domain.repository.Deliveries
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDao {

    @Query("SELECT * FROM $DELIVERY_TABLE ORDER BY deliveryId ASC")
    fun getDeliveries(): Flow<Deliveries>

    @Query("SELECT * FROM $DELIVERY_TABLE WHERE deliveryId = :id")
    suspend fun getDelivery(id: Int): Delivery

    @Insert(onConflict = IGNORE)
    suspend fun addDelivery(delivery: Delivery)

    @Update
    suspend fun updateDelivery(delivery: Delivery)

    @Delete
    suspend fun deleteDelivery(delivery: Delivery)

}