package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.OrderDetails
import com.example.inventorymanager.domain.repository.OrderDetailsRepository
import com.example.inventorymanager.data.dao.OrderDetailsDao
import kotlinx.coroutines.flow.Flow

class OrderDetailsRepositoryImpl(
    private val orderDetailsDao: OrderDetailsDao
) : OrderDetailsRepository {

    override fun getOrdersDetailsFromRoom(): Flow<List<OrderDetails>> {
        return orderDetailsDao.getAll() // Assuming you have a method that returns all orders as a Flow
    }

    override suspend fun getOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int): OrderDetails {
        return orderDetailsDao.getByIds(orderId, productId, warehouseId) ?: throw Exception("Order not found")
    }

    override suspend fun addOrderDetailsToRoom(orderDetails: OrderDetails) {
        orderDetailsDao.insert(orderDetails)
    }

    override suspend fun updateOrderDetailsInRoom(orderDetails: OrderDetails) {
        orderDetailsDao.update(orderDetails)
    }

    override suspend fun deleteOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int) {
        val orderDetails = orderDetailsDao.getByIds(orderId, productId, warehouseId)
            ?: throw Exception("Order not found")
        orderDetailsDao.delete(orderDetails)
    }
}