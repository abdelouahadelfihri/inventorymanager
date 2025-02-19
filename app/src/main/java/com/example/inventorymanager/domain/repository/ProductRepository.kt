package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.Order
import com.example.inventorymanager.domain.model.Product
import kotlinx.coroutines.flow.Flow


typealias Products = List<Product>

interface ProductRepository {

    fun getProductsFromRoom(): Flow<Products>

    suspend fun getProductFromRoom(id: Int): Product

    suspend fun addProductToRoom(product: Product)

    suspend fun updateProductInRoom(product: Product)

    suspend fun deleteProductFromRoom(id: Int)

    fun searchProducts(query: String): Flow<List<Product>>

}