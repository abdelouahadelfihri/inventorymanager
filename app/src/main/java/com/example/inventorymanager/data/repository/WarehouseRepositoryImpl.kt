package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Warehouse
import com.example.inventorymanager.data.dao.WarehouseDao
import com.example.inventorymanager.domain.repository.WarehouseRepository

class WarehouseRepositoryImpl(
    private val warehouseDao: WarehouseDao
) : WarehouseRepository {
    override fun getWarehousesFromRoom() = warehouseDao.getWarehouses()

    override suspend fun getWarehouseFromRoom(id: Int) = warehouseDao.getWarehouse(id)

    override suspend fun addWarehouseToRoom(warehouse: Warehouse) = warehouseDao.addWarehouse(warehouse)

    override suspend fun updateWarehouseInRoom(warehouse: Warehouse) = warehouseDao.updateWarehouse(warehouse)

    override suspend fun deleteWarehouseFromRoom(warehouse: Warehouse) = warehouseDao.deleteWarehouse(warehouse)
}