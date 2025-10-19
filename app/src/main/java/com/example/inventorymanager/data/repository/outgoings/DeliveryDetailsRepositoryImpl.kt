package com.example.inventorymanager.data.repository.outgoings

import com.example.inventorymanager.data.dao.outgoings.DeliveryDetailDao
import com.example.inventorymanager.domain.model.outgoings.SalesOrderLine
import com.example.inventorymanager.domain.repository.DeliveryDetailsRepository
import kotlinx.coroutines.flow.Flow

class DeliveryDetailsRepositoryImpl(
    private val deliveryDetailsDao: DeliveryDetailDao
) : DeliveryDetailsRepository {

    override fun getDeliveriesDetailsFromRoom(): Flow<List<SalesOrderLine>> {
        return deliveryDetailsDao.getAll() // Assuming you have a method that returns all orders as a Flow
    }

    override suspend fun getDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int): SalesOrderLine {
        return deliveryDetailsDao.getByIds(deliveryId, productId, warehouseId) ?: throw Exception("Delivery Details not found")
    }

    override suspend fun addDeliveryDetailsToRoom(deliveryDetails: SalesOrderLine) {
        deliveryDetailsDao.insert(deliveryDetails)
    }

    override suspend fun updateDeliveryDetailsInRoom(deliveryDetails: SalesOrderLine) {
        deliveryDetailsDao.update(deliveryDetails)
    }

    override suspend fun deleteDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int) {
        deliveryDetailsDao.delete(deliveryId, productId, warehouseId)
    }

}