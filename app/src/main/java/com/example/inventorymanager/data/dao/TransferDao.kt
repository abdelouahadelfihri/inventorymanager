package com.example.inventorymanager.data.dao

import androidx.room.Transaction
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.inventory.domain.model.Transfer
import com.example.inventory.domain.model.Warehouse
import com.example.inventorymanager.domain.relationshipdataclasses.ProviderWithOrders
import com.example.inventorymanager.domain.relationshipdataclasses.TransferWithWarehouses

@Dao
interface TransferDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWarehouse(warehouse: Warehouse): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransfer(transfer: Transfer): Long

    @Transaction
    @Query("SELECT * FROM transfer")
    suspend fun getTransfersWithWarehouses(): List<TransferWithWarehouses>

}