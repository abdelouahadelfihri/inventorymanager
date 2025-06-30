package com.example.inventorymanager.data.dao.masterdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.repository.masterdata.Warehouses
import kotlinx.coroutines.flow.Flow

@Dao
interface WarehouseDao {

    @Query("SELECT * FROM ${Constants.Companion.WAREHOUSE_TABLE} ORDER BY warehouseId ASC")
    fun getWarehouses(): Flow<Warehouses>

    @Query("SELECT * FROM ${Constants.Companion.WAREHOUSE_TABLE} WHERE warehouseId = :id")
    suspend fun getWarehouse(id: Int): Warehouse

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addWarehouse(warehouse: Warehouse)

    @Update
    suspend fun updateWarehouse(warehouse: Warehouse)

    @Delete
    suspend fun deleteWarehouse(id: Int)

}