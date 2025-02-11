package com.example.inventorymanager.data.dao

import androidx.room.Transaction
import androidx.room.Dao
import androidx.room.Query
import com.example.inventorymanager.domain.relationshipdataclasses.ProviderWithOrders

@Dao
interface ProviderWithOrdersDao {
    @Transaction
    @Query("SELECT * FROM provider WHERE providerId = :providerId")
    suspend fun getProviderWithOrders(providerId: Int): ProviderWithOrders?
}