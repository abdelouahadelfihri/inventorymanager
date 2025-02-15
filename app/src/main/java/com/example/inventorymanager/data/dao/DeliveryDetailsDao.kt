package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventory.domain.model.DeliveryDetails
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_DETAILS_TABLE

@Dao
interface DeliveryDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(deliveryDetails: DeliveryDetails)

    @Update
    suspend fun update(deliveryDetails: DeliveryDetails)

    @Delete
    suspend fun delete(deliveryDetails: DeliveryDetails)

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE WHERE deliveryId = :deliveryId")
    suspend fun getByDeliveryId(deliveryId: Int): List<DeliveryDetails>

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE WHERE productId = :productId")
    suspend fun getByProductId(productId: Int): List<DeliveryDetails>

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE WHERE warehouseId = :warehouseId")
    suspend fun getByWarehouseId(warehouseId: Int): List<DeliveryDetails>

    @Query("SELECT * FROM $DELIVERY_DETAILS_TABLE WHERE deliveryId = :deliveryId AND productId = :productId AND warehouseId = :warehouseId")
    suspend fun getByIds(deliveryId: Int, productId: Int, warehouseId: Int): DeliveryDetails?
}