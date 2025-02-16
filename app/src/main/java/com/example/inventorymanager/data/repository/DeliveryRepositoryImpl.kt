package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Delivery
import com.example.inventorymanager.data.dao.DeliveryDao
import com.example.inventorymanager.domain.repository.DeliveryRepository

class DeliveryRepositoryImpl(
    private val warehouseDao: DeliveryDao
) : DeliveryRepository {
    override fun getDeliveriesFromRoom() = warehouseDao.getDeliverys()

    override suspend fun getDeliveryFromRoom(id: Int) = warehouseDao.getDelivery(id)

    override suspend fun addDeliveryToRoom(warehouse: Delivery) = warehouseDao.addDelivery(warehouse)

    override suspend fun updateDeliveryInRoom(warehouse: Delivery) = warehouseDao.updateDelivery(warehouse)

    override suspend fun deleteDeliveryFromRoom(warehouse: Delivery) = warehouseDao.deleteDelivery(warehouse)
}