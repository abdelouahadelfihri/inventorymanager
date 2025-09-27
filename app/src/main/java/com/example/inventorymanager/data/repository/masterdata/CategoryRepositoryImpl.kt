package com.example.inventorymanager.data.repository.masterdata

import com.example.inventorymanager.data.dao.masterdata.CategoryDao
import com.example.inventorymanager.domain.model.masterdata.Inventory
import com.example.inventorymanager.data.dao.masterdata.InventoryDao
import com.example.inventorymanager.domain.model.masterdata.Category
import com.example.inventorymanager.domain.repository.masterdata.CategoryRepository
import com.example.inventorymanager.domain.repository.masterdata.InventoryRepository

class CategoryRepositoryImpl(
    private val categoryDao: CategoryDao
) : CategoryRepository {
    override fun getCategoriesFromRoom() = categoryDao.getCategories()

    override suspend fun getCategoryFromRoom(id: Int) = categoryDao.getCategory(id)

    override suspend fun addCategoryToRoom(category: Category) = categoryDao.addCategory(category)

    override suspend fun updateCategoryInRoom(category: Category) = categoryDao.updateCategory(category)

    override suspend fun deleteCategoryFromRoom(id: Int) = categoryDao.deleteCategory(id)

}