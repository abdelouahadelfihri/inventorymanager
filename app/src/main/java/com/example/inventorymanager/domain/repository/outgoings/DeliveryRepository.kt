package com.example.inventorymanager.domain.repository.outgoings

import com.example.inventorymanager.domain.common.Customers
import com.example.inventorymanager.domain.common.Deliveries
import com.example.inventorymanager.domain.model.outgoings.SalesOrder
import kotlinx.coroutines.flow.Flow

interface DeliveryRepository {

    fun getDeliveriesFromRoom(): Flow<Deliveries>

    fun getCustomersFromRoom(): Flow<Customers>

    suspend fun getDeliveryFromRoom(id: Int): SalesOrder

    suspend fun addDeliveryToRoom(delivery: SalesOrder)

    suspend fun updateDeliveryInRoom(delivery: SalesOrder)

    suspend fun deleteDeliveryFromRoom(id: Int)

}