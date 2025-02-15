package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.Warehouse
import com.example.inventorymanager.core.Constants.Companion.WAREHOUSE_TABLE
import com.example.inventorymanager.domain.repository.Warehouses
import kotlinx.coroutines.flow.Flow

@Dao
interface WarehouseDao {

    @Query("SELECT * FROM $WAREHOUSE_TABLE ORDER BY warehouseId ASC")
    fun getWarehouses(): Flow<Warehouses>

    @Query("SELECT * FROM $WAREHOUSE_TABLE WHERE warehouseId = :id")
    suspend fun getWarehouse(id: Int): Warehouse

    @Insert(onConflict = IGNORE)
    suspend fun addWarehouse(warehouse: Warehouse)

    @Update
    suspend fun updateWarehouse(warehouse: Warehouse)

    @Delete
    suspend fun deleteWarehouse(warehouse: Warehouse)

}