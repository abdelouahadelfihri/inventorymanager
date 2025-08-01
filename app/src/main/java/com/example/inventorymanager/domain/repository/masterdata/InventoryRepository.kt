package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Inventory
import kotlinx.coroutines.flow.Flow

typealias Inventories = List<Inventory>

interface InventoryRepository {

    fun getInventoriesFromRoom(): Flow<Inventories>

    suspend fun getInventoryFromRoom(id: Int): Inventory

    suspend fun addInventoryToRoom(inventory: Inventory)

    suspend fun updateInventoryInRoom(inventory: Inventory)

    suspend fun deleteInventoryFromRoom(id: Int)

}