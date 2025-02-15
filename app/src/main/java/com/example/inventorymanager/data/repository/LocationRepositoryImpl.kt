package com.example.inventorymanager.data.repository

import com.example.inventorymanager.data.dao.LocationDao
import com.example.inventorymanager.domain.model.Warehouse
import com.example.inventorymanager.domain.repository.WarehouseRepository

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : WarehouseRepository {
    override fun getWarehousesFromRoom() = locationDao.getLocations()

    override suspend fun getWarehouseFromRoom(id: Int) = warehouseDao.getWarehouse(id)

    override suspend fun addWarehouseToRoom(warehouse: Warehouse) = warehouseDao.addWarehouse(warehouse)

    override suspend fun updateWarehouseInRoom(warehouse: Warehouse) = warehouseDao.updateWarehouse(warehouse)

    override suspend fun deleteWarehouseFromRoom(warehouse: Warehouse) = warehouseDao.deleteWarehouse(warehouse)
}