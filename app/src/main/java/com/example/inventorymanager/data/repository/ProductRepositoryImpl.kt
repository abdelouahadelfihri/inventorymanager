package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Item
import com.example.inventorymanager.data.dao.ProductDao
import com.example.inventorymanager.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val productDao: ProductDao
) : ProductRepository {
    override fun getProductsFromRoom() = productDao.getProducts()

    override suspend fun getProductFromRoom(id: Int) = productDao.getProduct(id)

    override suspend fun addProductToRoom(item: Item) = productDao.addProduct(item)

    override suspend fun updateProductInRoom(item: Item) = productDao.updateProduct(item)

    override suspend fun deleteProductFromRoom(id: Int) = productDao.deleteProduct(id)

    override fun searchProducts(query: String): Flow<List<Item>> {
        return productDao.searchProducts("%$query%")
    }
}