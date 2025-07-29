package com.example.inventorymanager.data.repository.masterdata

import com.example.inventorymanager.data.dao.masterdata.ItemDao
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.domain.repository.masterdata.ProductRepository

class ProductRepositoryImpl(
    private val productDao: ItemDao
) : ProductRepository {
    override fun getProductsFromRoom() = productDao.getProducts()

    override suspend fun getProductFromRoom(id: Int) = productDao.getProduct(id)

    override suspend fun addProductToRoom(item: Item) = productDao.addProduct(item)

    override suspend fun updateProductInRoom(item: Item) = productDao.updateProduct(item)

    override suspend fun deleteProductFromRoom(id: Int) = productDao.deleteProduct(id)

}