package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.Provider
import kotlinx.coroutines.flow.Flow


typealias Providers = List<Provider>

interface ProviderRepository {

    fun getProvidersFromRoom(): Flow<Providers>

    suspend fun getProviderFromRoom(id: Int): Provider

    suspend fun addProviderToRoom(provider: Provider)

    suspend fun updateProviderInRoom(provider: Provider)

    suspend fun deleteProviderFromRoom(id: Int)

    fun searchProviders(query: String): Flow<List<Provider>>

}