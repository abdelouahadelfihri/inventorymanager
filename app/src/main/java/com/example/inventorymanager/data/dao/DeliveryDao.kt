package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventory.domain.model.Delivery
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_TABLE

@Dao
interface DeliveryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(delivery: Delivery)

    @Update
    suspend fun update(delivery: Delivery)

    @Delete
    suspend fun delete(delivery: Delivery)

    @Query("SELECT * FROM $DELIVERY_TABLE")
    suspend fun getAll(): List<Delivery>

    @Query("SELECT * FROM $DELIVERY_TABLE WHERE deliveryId = :id")
    suspend fun getById(id: Int): Delivery?
}