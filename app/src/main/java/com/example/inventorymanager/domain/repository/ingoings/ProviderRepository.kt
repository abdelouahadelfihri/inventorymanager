package com.example.inventorymanager.domain.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.Supplier
import kotlinx.coroutines.flow.Flow


typealias Providers = List<Supplier>

interface ProviderRepository {

    fun getProvidersFromRoom(): Flow<Providers>

    suspend fun getProviderFromRoom(id: Int): Supplier

    suspend fun addProviderToRoom(provider: Supplier)

    suspend fun updateProviderInRoom(provider: Supplier)

    suspend fun deleteProviderFromRoom(id: Int)

}