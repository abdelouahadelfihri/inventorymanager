package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.Order
import kotlinx.coroutines.flow.Flow


typealias Orders = List<Order>

interface OrderRepository {

    fun getOrdersFromRoom(): Flow<Orders>

    suspend fun getOrderFromRoom(id: Int): Order

    suspend fun addOrderToRoom(order: Order)

    suspend fun updateOrderInRoom(order: Order)

    suspend fun deleteOrderFromRoom(order: Order)

}