package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Inventory
import com.example.inventorymanager.data.dao.InventoryDao
import com.example.inventorymanager.domain.repository.InventoryRepository

class InventoryRepositoryImpl(
    private val inventoryDao: InventoryDao
) : InventoryRepository {
    override fun getInventoriesFromRoom() = inventoryDao.getInventories()

    override suspend fun getInventoryFromRoom(id: Int) = inventoryDao.getInventory(id)

    override suspend fun addInventoryToRoom(inventory: Inventory) = inventoryDao.addInventory(inventory)

    override suspend fun updateInventoryInRoom(inventory: Inventory) = inventoryDao.updateInventory(inventory)

    override suspend fun deleteInventoryFromRoom(inventory: Inventory) = inventoryDao.deleteInventory(inventory)
}
