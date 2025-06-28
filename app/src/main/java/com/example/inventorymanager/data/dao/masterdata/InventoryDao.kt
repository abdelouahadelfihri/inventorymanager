package com.example.inventorymanager.data.dao.masterdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.masterdata.Inventory
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {

    @Query("SELECT * FROM ${Constants.Companion.INVENTORY_TABLE} ORDER BY inventoryId ASC")
    fun getInventories(): Flow<List<Inventory>>

    @Query("SELECT * FROM ${Constants.Companion.INVENTORY_TABLE} WHERE inventoryId = :id")
    suspend fun getInventory(id: Int): Inventory

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addInventory(inventory: Inventory)

    @Update
    suspend fun updateInventory(inventory: Inventory)

    @Delete
    suspend fun deleteInventory(id: Int)

}