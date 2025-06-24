package com.example.inventorymanager.data.repository

import com.example.inventory.domain.model.DeliveryDetails
import com.example.inventorymanager.data.dao.DeliveryDetailsDao
import com.example.inventorymanager.domain.repository.DeliveryDetailsRepository
import kotlinx.coroutines.flow.Flow

class DeliveryDetailsRepositoryImpl(
    private val deliveryDetailsDao: DeliveryDetailsDao
) : DeliveryDetailsRepository {

    override fun getDeliveriesDetailsFromRoom(): Flow<List<DeliveryDetails>> {
        return deliveryDetailsDao.getAll() // Assuming you have a method that returns all orders as a Flow
    }

    override suspend fun getDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int): DeliveryDetails {
        return deliveryDetailsDao.getByIds(deliveryId, productId, warehouseId) ?: throw Exception("Delivery Details not found")
    }

    override suspend fun addDeliveryDetailsToRoom(deliveryDetails: DeliveryDetails) {
        deliveryDetailsDao.insert(deliveryDetails)
    }

    override suspend fun updateDeliveryDetailsInRoom(deliveryDetails: DeliveryDetails) {
        deliveryDetailsDao.update(deliveryDetails)
    }

    override suspend fun deleteDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int) {
        val deliveryDetails = deliveryDetailsDao.getByIds(deliveryId, productId, warehouseId)
            ?: throw Exception("Order not found")
        deliveryDetailsDao.delete(deliveryDetails)
    }

    override fun searchDeliveriesDetails(query: String): Flow<List<DeliveryDetails>> {
        return deliveryDetailsDao.searchDeliveriesDetails("%$query%")
    }
}