package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.ingoings.OrderDetail
import kotlinx.coroutines.flow.Flow

typealias OrdersDetails = List<OrderDetail>

interface OrderDetailsRepository {

    fun getOrdersDetailsFromRoom(): Flow<OrdersDetails>

    suspend fun getOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int): OrderDetail

    suspend fun addOrderDetailsToRoom(orderDetails: OrderDetail)

    suspend fun updateOrderDetailsInRoom(orderDetails: OrderDetail)

    suspend fun deleteOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int)

}