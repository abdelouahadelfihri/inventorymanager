package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.data.dao.ProductDao
import com.example.inventorymanager.domain.model.Order
import com.example.inventorymanager.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(
    private val productDao: ProductDao
) : ProductRepository {
    override fun getProductsFromRoom() = productDao.getProducts()

    override suspend fun getProductFromRoom(id: Int) = productDao.getProduct(id)

    override suspend fun addProductToRoom(product: Product) = productDao.addProduct(product)

    override suspend fun updateProductInRoom(product: Product) = productDao.updateProduct(product)

    override suspend fun deleteProductFromRoom(id: Int) = productDao.deleteProduct(id)

    override fun searchProducts(query: String): Flow<List<Product>> {
        return productDao.searchProducts("%$query%")
    }
}