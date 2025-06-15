package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Delivery
import com.example.inventorymanager.data.dao.DeliveryDao
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.Flow

class DeliveryRepositoryImpl(
    private val deliveryDao: DeliveryDao
) : DeliveryRepository {
    override fun getDeliveriesFromRoom() = deliveryDao.getDeliveries()

    override suspend fun getDeliveryFromRoom(id: Int) = deliveryDao.getDelivery(id)

    override suspend fun addDeliveryToRoom(delivery: Delivery) = deliveryDao.addDelivery(delivery)

    override suspend fun updateDeliveryInRoom(delivery: Delivery) = deliveryDao.updateDelivery(delivery)

    override suspend fun deleteDeliveryFromRoom(id: Int) = deliveryDao.deleteDelivery(id)

    override fun searchDeliveries(query: String): Flow<List<Delivery>> {
        return deliveryDao.searchDeliveries("%$query%")
    }
}