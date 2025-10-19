package com.example.inventorymanager.domain.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.PurchaseOrderLine
import kotlinx.coroutines.flow.Flow

typealias OrdersDetails = List<PurchaseOrderLine>

interface OrderDetailRepository {

    fun getOrdersDetailsFromRoom(): Flow<OrdersDetails>

    suspend fun getOrderDetailFromRoom(orderId: Int, productId: Int, warehouseId: Int): PurchaseOrderLine

    suspend fun addOrderDetailToRoom(orderDetails: PurchaseOrderLine)

    suspend fun updateOrderDetailInRoom(orderDetails: PurchaseOrderLine)

    suspend fun deleteOrderDetailFromRoom(orderId: Int, productId: Int, warehouseId: Int)

}