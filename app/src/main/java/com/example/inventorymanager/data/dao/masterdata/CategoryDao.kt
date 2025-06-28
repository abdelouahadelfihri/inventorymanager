package com.example.inventorymanager.data.dao.masterdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.common.Categories
import com.example.inventorymanager.domain.model.masterdata.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM ${Constants.Companion.CATEGORY_TABLE} ORDER BY id ASC")
    fun getCategories(): Flow<Categories>

    @Query("SELECT * FROM ${Constants.Companion.CATEGORY_TABLE} WHERE id = :id")
    suspend fun getCategory(id: Int): Category

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(id: Int)

}