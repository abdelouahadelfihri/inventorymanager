package com.example.inventorymanager.data.dao.ingoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.ingoings.Provider
import com.example.inventorymanager.domain.repository.Providers
import kotlinx.coroutines.flow.Flow

@Dao
interface ProviderDao {

    @Query("SELECT * FROM ${Constants.Companion.PROVIDER_TABLE} ORDER BY providerId ASC")
    fun getProviders(): Flow<Providers>

    @Query("SELECT * FROM ${Constants.Companion.PROVIDER_TABLE} WHERE providerId = :id")
    suspend fun getProvider(id: Int): Provider

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addProvider(product: Provider)

    @Update
    suspend fun updateProvider(product: Provider)

    @Delete
    suspend fun deleteProvider(id: Int)

}