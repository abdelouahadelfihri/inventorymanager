package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TABLE
import com.example.inventorymanager.domain.model.Inventory
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import com.example.inventorymanager.domain.model.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {

    @Query("SELECT * FROM $INVENTORY_TABLE ORDER BY inventoryId ASC")
    fun getInventories(): Flow<List<Inventory>>

    @Query("SELECT * FROM $INVENTORY_TABLE WHERE inventoryId = :id")
    suspend fun getInventory(id: Int): Inventory

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addInventory(inventory: Inventory)

    @Update
    suspend fun updateInventory(inventory: Inventory)

    @Delete
    suspend fun deleteInventory(inventory: Inventory)

    @Query("SELECT * FROM $INVENTORY_TABLE WHERE name LIKE :searchQuery")
    fun searchInventory(searchQuery: String): Flow<List<Inventory>>
}
