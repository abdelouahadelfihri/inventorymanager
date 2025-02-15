package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.Inventory
import kotlinx.coroutines.flow.Flow

typealias Inventories = List<Inventory>

interface InventoryRepository {

    fun getInventoriesFromRoom(): Flow<Inventories>

    suspend fun getInventoryFromRoom(id: Int): Inventory

    suspend fun addInventoryToRoom(inventory: Inventory)

    suspend fun updateInventoryInRoom(inventory: Inventory)

    suspend fun deleteInventoryFromRoom(inventory: Inventory)
}
