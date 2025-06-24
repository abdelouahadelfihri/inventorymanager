package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.outgoings.Delivery
import kotlinx.coroutines.flow.Flow
import com.example.inventorymanager.domain.common.Customers
import com.example.inventorymanager.domain.common.Deliveries

interface DeliveryRepository {

    fun getDeliveriesFromRoom(): Flow<Deliveries>

    fun getCustomersFromRoom(): Flow<Customers>

    suspend fun getDeliveryFromRoom(id: Int): Delivery

    suspend fun addDeliveryToRoom(delivery: Delivery)

    suspend fun updateDeliveryInRoom(delivery: Delivery)

    suspend fun deleteDeliveryFromRoom(id: Int)

    fun searchDeliveries(query: String): Flow<List<Delivery>>

}