package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.relationshipdataclasses.WarehouseWithLocation
import kotlinx.coroutines.flow.Flow


typealias Warehouses = List<Warehouse>
typealias WarehousesWithLocation = List<WarehouseWithLocation>

interface WarehouseRepository {

    fun getWarehousesFromRoom(): Flow<Warehouses>

    fun getWarehousesWithLocation(): Flow<WarehousesWithLocation>

    suspend fun getWarehouseFromRoom(id: Int): Warehouse

    suspend fun addWarehouseToRoom(warehouse: Warehouse)

    suspend fun updateWarehouseInRoom(warehouse: Warehouse)

    suspend fun deleteWarehouseFromRoom(id: Int)

}