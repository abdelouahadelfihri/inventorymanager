package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.Delivery
import kotlinx.coroutines.flow.Flow


typealias Deliveries = List<Delivery>

interface DeliveryRepository {

    fun getDeliveriesFromRoom(): Flow<Deliveries>

    suspend fun getDeliveryFromRoom(id: Int): Delivery

    suspend fun addDeliveryToRoom(delivery: Delivery)

    suspend fun updateDeliveryInRoom(delivery: Delivery)

    suspend fun deleteDeliveryFromRoom(delivery: Delivery)

}