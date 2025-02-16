package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Delivery
import com.example.inventorymanager.data.dao.DeliveryDao
import com.example.inventorymanager.domain.repository.DeliveryRepository

class DeliveryRepositoryImpl(
    private val deliveryDao: DeliveryDao
) : DeliveryRepository {
    override fun getDeliveriesFromRoom() = deliveryDao.getDeliveries()

    override suspend fun getDeliveryFromRoom(id: Int) = deliveryDao.getDelivery(id)

    override suspend fun addDeliveryToRoom(delivery: Delivery) = deliveryDao.addDelivery(delivery)

    override suspend fun updateDeliveryInRoom(delivery: Delivery) = deliveryDao.updateDelivery(delivery)

    override suspend fun deleteDeliveryFromRoom(delivery: Delivery) = deliveryDao.deleteDelivery(delivery)
}