package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.Provider
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.repository.Providers
import kotlinx.coroutines.flow.Flow

@Dao
interface ProviderDao {

    @Query("SELECT * FROM $ORDER_TABLE ORDER BY providerId ASC")
    fun getProviders(): Flow<Providers>

    @Query("SELECT * FROM $ORDER_TABLE WHERE providerId = :id")
    suspend fun getProvider(id: Int): Provider

    @Insert(onConflict = IGNORE)
    suspend fun addProvider(provider: Provider)

    @Update
    suspend fun updateProvider(provider: Provider)

    @Delete
    suspend fun deleteProvider(provider: Provider)

}