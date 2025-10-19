package com.example.inventorymanager.domain.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.PurchaseOrder
import kotlinx.coroutines.flow.Flow


typealias Orders = List<PurchaseOrder>

interface OrderRepository {

    fun getOrdersFromRoom(): Flow<Orders>

    suspend fun getOrderFromRoom(id: Int): PurchaseOrder

    suspend fun addOrderToRoom(order: PurchaseOrder)

    suspend fun updateOrderInRoom(order: PurchaseOrder)

    suspend fun deleteOrderFromRoom(id: Int)

}