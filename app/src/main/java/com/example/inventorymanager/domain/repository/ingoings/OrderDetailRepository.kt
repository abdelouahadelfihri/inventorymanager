package com.example.inventorymanager.domain.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.OrderDetail
import kotlinx.coroutines.flow.Flow

typealias OrdersDetails = List<OrderDetail>

interface OrderDetailRepository {

    fun getOrdersDetailsFromRoom(): Flow<OrdersDetails>

    suspend fun getOrderDetailFromRoom(orderId: Int, productId: Int, warehouseId: Int): OrderDetail

    suspend fun addOrderDetailToRoom(orderDetails: OrderDetail)

    suspend fun updateOrderDetailInRoom(orderDetails: OrderDetail)

    suspend fun deleteOrderDetailFromRoom(orderId: Int, productId: Int, warehouseId: Int)

}