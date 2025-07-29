package com.example.inventorymanager.data.dao.masterdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.domain.repository.masterdata.Products
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM ${Constants.Companion.ITEM_TABLE} ORDER BY productId ASC")
    fun getItems(): Flow<Products>

    @Query("SELECT * FROM ${Constants.Companion.ITEM_TABLE} WHERE productId = :id")
    suspend fun getItem(id: Int): Item

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Delete
    suspend fun deleteItem(id: Int)

}