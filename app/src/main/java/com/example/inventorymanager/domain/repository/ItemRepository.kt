package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.masterdata.Item
import kotlinx.coroutines.flow.Flow


typealias Items = List<Item>

interface ItemRepository {

    fun getItemsFromRoom(): Flow<Items>

    suspend fun getItemFromRoom(id: Int): Item

    suspend fun addItemToRoom(item: Item)

    suspend fun updateItemInRoom(item: Item)

    suspend fun deleteItemFromRoom(id: Int)

}