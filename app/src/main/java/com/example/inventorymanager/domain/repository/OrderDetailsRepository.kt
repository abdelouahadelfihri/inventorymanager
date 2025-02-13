package com.example.inventorymanager.domain.repository

import com.example.inventory.domain.model.OrderDetails
import kotlinx.coroutines.flow.Flow


typealias OrdersDetails = List<OrderDetails>

interface OrderDetailsRepository {

    fun getOrdersDetailsFromRoom(): Flow<OrdersDetails>

    suspend fun getOrderDetailsFromRoom(orderId: Int,productId: Int,warehouseId: Int): OrderDetails

    suspend fun addOrderDetailsToRoom(orderDetails: OrderDetails)

    suspend fun updateOrderDetailsInRoom(orderDetails: OrderDetails)

    suspend fun deleteOrderDetailsFromRoom(orderId: Int,productId: Int,warehouseId: Int)

}