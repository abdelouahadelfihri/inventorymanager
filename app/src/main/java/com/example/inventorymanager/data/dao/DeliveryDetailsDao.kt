package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventorymanager.domain.model.outgoings.DeliveryDetails
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_DETAILS_TABLE

import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(deliveryDetails: DeliveryDetails)

    @Update
    suspend fun update(deliveryDetails: DeliveryDetails)

    @Delete
    suspend fun delete(deliveryId: Int, productId: Int, warehouseId: Int): Int

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE WHERE deliveryId = :deliveryId AND productId = :productId AND warehouseId = :warehouseId LIMIT 1")
    suspend fun getByIds(deliveryId: Int, productId: Int, warehouseId: Int): DeliveryDetails?

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE")
    fun getAll(): Flow<List<DeliveryDetails>>

}