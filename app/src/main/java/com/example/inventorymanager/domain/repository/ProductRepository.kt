package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.masterdata.Product
import kotlinx.coroutines.flow.Flow


typealias Products = List<Product>

interface ProductRepository {

    fun getProductsFromRoom(): Flow<Products>

    suspend fun getProductFromRoom(id: Int): Product

    suspend fun addProductToRoom(item: Product)

    suspend fun updateProductInRoom(item: Product)

    suspend fun deleteProductFromRoom(id: Int)

}