package com.example.inventorymanager.data.repository.outgoings

import com.example.inventorymanager.data.dao.outgoings.DeliveryDao
import com.example.inventorymanager.domain.model.outgoings.SalesOrder
import com.example.inventorymanager.domain.repository.outgoings.DeliveryRepository

class DeliveryRepositoryImpl(
    private val deliveryDao: DeliveryDao
) : DeliveryRepository {
    override fun getDeliveriesFromRoom() = deliveryDao.getDeliveries()
    override fun getCustomersFromRoom() = deliveryDao.getCustomers()

    override suspend fun getDeliveryFromRoom(id: Int) = deliveryDao.getDelivery(id)

    override suspend fun addDeliveryToRoom(delivery: SalesOrder) = deliveryDao.addDelivery(delivery)

    override suspend fun updateDeliveryInRoom(delivery: SalesOrder) = deliveryDao.updateDelivery(delivery)

    override suspend fun deleteDeliveryFromRoom(id: Int) = deliveryDao.deleteDelivery(id)

}