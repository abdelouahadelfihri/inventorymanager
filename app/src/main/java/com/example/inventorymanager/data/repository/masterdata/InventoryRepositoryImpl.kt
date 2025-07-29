package com.example.inventorymanager.data.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Inventory
import com.example.inventorymanager.data.dao.masterdata.InventoryDao
import com.example.inventorymanager.domain.repository.masterdata.InventoryRepository

class InventoryRepositoryImpl(
    private val inventoryDao: InventoryDao
) : InventoryRepository {
    override fun getInventoriesFromRoom() = inventoryDao.getInventories()

    override suspend fun getInventoryFromRoom(id: Int) = inventoryDao.getInventory(id)

    override suspend fun addInventoryToRoom(inventory: Inventory) = inventoryDao.addInventory(inventory)

    override suspend fun updateInventoryInRoom(inventory: Inventory) = inventoryDao.updateInventory(inventory)

    override suspend fun deleteInventoryFromRoom(id: Int) = inventoryDao.deleteInventory(id)

}