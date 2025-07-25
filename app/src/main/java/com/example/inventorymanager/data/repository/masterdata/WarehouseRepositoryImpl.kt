package com.example.inventorymanager.data.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.data.dao.masterdata.WarehouseDao
import com.example.inventorymanager.domain.repository.masterdata.WarehouseRepository

class WarehouseRepositoryImpl(
    private val warehouseDao: WarehouseDao
) : WarehouseRepository {
    override fun getWarehousesFromRoom() = warehouseDao.getWarehouses()

    override suspend fun getWarehouseFromRoom(id: Int) = warehouseDao.getWarehouse(id)

    override suspend fun addWarehouseToRoom(warehouse: Warehouse) = warehouseDao.addWarehouse(warehouse)

    override suspend fun updateWarehouseInRoom(warehouse: Warehouse) = warehouseDao.updateWarehouse(warehouse)

    override suspend fun deleteWarehouseFromRoom(warehouse: Warehouse) = warehouseDao.deleteWarehouse(warehouse)

}