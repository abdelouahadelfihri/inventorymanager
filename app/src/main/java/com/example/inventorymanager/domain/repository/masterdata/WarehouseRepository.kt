package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Warehouse
import kotlinx.coroutines.flow.Flow


typealias Warehouses = List<Warehouse>

interface WarehouseRepository {

    fun getWarehousesFromRoom(): Flow<Warehouses>

    suspend fun getWarehouseFromRoom(id: Int): Warehouse

    suspend fun addWarehouseToRoom(warehouse: Warehouse)

    suspend fun updateWarehouseInRoom(warehouse: Warehouse)

    suspend fun deleteWarehouseFromRoom(id: Int)

}