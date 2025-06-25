package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.Item
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_TABLE
import com.example.inventorymanager.domain.repository.Products
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM $PRODUCT_TABLE ORDER BY productId ASC")
    fun getProducts(): Flow<Products>

    @Query("SELECT * FROM $PRODUCT_TABLE WHERE productId = :id")
    suspend fun getProduct(id: Int): Item

    @Insert(onConflict = IGNORE)
    suspend fun addProduct(item: Item)

    @Update
    suspend fun updateProduct(item: Item)

    @Delete
    suspend fun deleteProduct(id: Int)

}