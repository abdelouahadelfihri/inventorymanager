package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.outgoings.Customer
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TABLE
import com.example.inventorymanager.domain.common.Categories
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM $CATEGORY_TABLE ORDER BY cateogryId ASC")
    fun getCategories(): Flow<Customers>

    @Query("SELECT * FROM $CATEGORY_TABLE WHERE categoryId = :id")
    suspend fun getCategory(id: Int): Category

    @Insert(onConflict = IGNORE)
    suspend fun addCategory(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(id: Int)

}