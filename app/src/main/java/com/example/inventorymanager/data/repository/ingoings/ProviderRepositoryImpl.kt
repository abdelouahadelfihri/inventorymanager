package com.example.inventorymanager.data.repository.ingoings

import com.example.inventorymanager.data.dao.ingoings.SupplierDao
import com.example.inventorymanager.domain.model.ingoings.Supplier
import com.example.inventorymanager.domain.repository.ingoings.ProviderRepository

class ProviderRepositoryImpl(
    private val providerDao: SupplierDao
) : ProviderRepository {

    override fun getProvidersFromRoom() = providerDao.getProviders()

    override suspend fun getProviderFromRoom(id: Int) = providerDao.getProvider(id)

    override suspend fun addProviderToRoom(provider: Supplier) = providerDao.addProvider(provider)

    override suspend fun updateProviderInRoom(provider: Supplier) = providerDao.updateProvider(provider)

    override suspend fun deleteProviderFromRoom(id: Int) = providerDao.deleteProvider(id)

}