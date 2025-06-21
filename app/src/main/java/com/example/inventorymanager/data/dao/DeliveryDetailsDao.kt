package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventory.domain.model.DeliveryDetails
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_DETAILS_TABLE
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_TABLE
import com.example.inventorymanager.domain.model.Delivery

import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(deliveryDetails: DeliveryDetails)

    @Update
    suspend fun update(deliveryDetails: DeliveryDetails)

    @Delete
    suspend fun delete(deliveryDetails: DeliveryDetails)

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE WHERE deliveryId = :orderId AND productId = :productId AND warehouseId = :warehouseId LIMIT 1")
    suspend fun getByIds(orderId: Int, productId: Int, warehouseId: Int): DeliveryDetails?

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE")
    fun getAll(): Flow<List<DeliveryDetails>>

}