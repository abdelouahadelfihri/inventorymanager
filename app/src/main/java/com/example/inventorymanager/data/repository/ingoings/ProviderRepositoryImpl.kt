package com.example.inventorymanager.data.repository.ingoings

import com.example.inventorymanager.data.dao.ProviderDao
import com.example.inventorymanager.domain.model.ingoings.Provider
import com.example.inventorymanager.domain.repository.ProviderRepository
import kotlinx.coroutines.flow.Flow

class ProviderRepositoryImpl(
    private val providerDao: ProviderDao
) : ProviderRepository {

    override fun getProvidersFromRoom() = providerDao.getProviders()

    override suspend fun getProviderFromRoom(id: Int) = providerDao.getProvider(id)

    override suspend fun addProviderToRoom(provider: Provider) = providerDao.addProvider(provider)

    override suspend fun updateProviderInRoom(provider: Provider) = providerDao.updateProvider(provider)

    override suspend fun deleteProviderFromRoom(id: Int) = providerDao.deleteProvider(id)

}