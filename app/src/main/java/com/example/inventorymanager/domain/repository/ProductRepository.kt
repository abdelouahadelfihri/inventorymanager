package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.masterdata.Item
import kotlinx.coroutines.flow.Flow


typealias Products = List<Item>

interface ProductRepository {

    fun getProductsFromRoom(): Flow<Products>

    suspend fun getProductFromRoom(id: Int): Item

    suspend fun addProductToRoom(item: Item)

    suspend fun updateProductInRoom(item: Item)

    suspend fun deleteProductFromRoom(id: Int)

}