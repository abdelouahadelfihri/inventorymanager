package com.example.inventorymanager.data.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.PurchaseOrderLine
import com.example.inventorymanager.domain.repository.OrderDetailsRepository
import com.example.inventorymanager.data.dao.ingoings.OrderDetailDao
import kotlinx.coroutines.flow.Flow

class OrderDetailsRepositoryImpl(
    private val orderDetailsDao: OrderDetailDao
) : OrderDetailsRepository {

    override fun getOrdersDetailsFromRoom(): Flow<List<PurchaseOrderLine>> {
        return orderDetailsDao.getAll() // Assuming you have a method that returns all orders as a Flow
    }

    override suspend fun getOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int): PurchaseOrderLine {
        return orderDetailsDao.getByIds(orderId, productId, warehouseId) ?: throw Exception("Order not found")
    }

    override suspend fun addOrderDetailsToRoom(orderDetails: PurchaseOrderLine) {
        orderDetailsDao.insert(orderDetails)
    }

    override suspend fun updateOrderDetailsInRoom(orderDetails: PurchaseOrderLine) {
        orderDetailsDao.update(orderDetails)
    }

    override suspend fun deleteOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int) {
        orderDetailsDao.delete(orderId, productId, warehouseId)
    }

}