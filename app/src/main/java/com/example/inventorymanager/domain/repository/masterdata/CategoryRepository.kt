package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Category
import kotlinx.coroutines.flow.Flow

typealias Categories = List<Category>

interface InventoryRepository {

    fun getCategoriesFromRoom(): Flow<Categories>

    suspend fun getCategoryFromRoom(id: Int): Category

    suspend fun addCategoryToRoom(category: Category)

    suspend fun updateCategoryInRoom(category: Category)

    suspend fun deleteCategoryFromRoom(id: Int)

}