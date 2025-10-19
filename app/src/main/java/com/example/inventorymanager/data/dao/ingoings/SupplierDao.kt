package com.example.inventorymanager.data.dao.ingoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.masterdata.Supplier
import com.example.inventorymanager.domain.repository.ingoings.Providers
import kotlinx.coroutines.flow.Flow

@Dao
interface SupplierDao {

    @Query("SELECT * FROM ${Constants.Companion.PROVIDER_TABLE} ORDER BY supplierId ASC")
    fun getSuppliers(): Flow<Providers>

    @Query("SELECT * FROM ${Constants.Companion.PROVIDER_TABLE} WHERE supplierId = :id")
    suspend fun getSupplier(id: Int): Supplier

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addSupplier(product: Supplier)

    @Update
    suspend fun updateSupplier(product: Supplier)

    @Delete
    suspend fun deleteSupplier(id: Int)

}