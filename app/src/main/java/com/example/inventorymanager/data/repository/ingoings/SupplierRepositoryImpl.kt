package com.example.inventorymanager.data.repository.ingoings

import com.example.inventorymanager.data.dao.ingoings.SupplierDao
import com.example.inventorymanager.domain.model.masterdata.Supplier
import com.example.inventorymanager.domain.repository.ingoings.ProviderRepository

class SupplierRepositoryImpl(
    private val supplierDao: SupplierDao
) : SupplierRepository {

    override fun getSuppliersFromRoom() = supplierDao.getSuppliers()

    override suspend fun getSupplierFromRoom(id: Int) = supplierDao.getSupplier(id)

    override suspend fun addSupplierToRoom(supplier: Supplier) = supplierDao.addSupplier(supplier)

    override suspend fun updateSupplierInRoom(supplier: Supplier) = supplierDao.updateSupplier(supplier)

    override suspend fun deleteSupplierFromRoom(id: Int) = supplierDao.deleteSupplier(id)

}