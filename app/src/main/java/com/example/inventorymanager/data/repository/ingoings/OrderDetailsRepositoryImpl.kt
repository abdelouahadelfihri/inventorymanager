package com.example.inventorymanager.data.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.OrderDetail
import com.example.inventorymanager.domain.repository.OrderDetailsRepository
import com.example.inventorymanager.data.dao.ingoings.OrderDetailDao
import kotlinx.coroutines.flow.Flow

class OrderDetailsRepositoryImpl(
    private val orderDetailsDao: OrderDetailDao
) : OrderDetailsRepository {

    override fun getOrdersDetailsFromRoom(): Flow<List<OrderDetail>> {
        return orderDetailsDao.getAll() // Assuming you have a method that returns all orders as a Flow
    }

    override suspend fun getOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int): OrderDetail {
        return orderDetailsDao.getByIds(orderId, productId, warehouseId) ?: throw Exception("Order not found")
    }

    override suspend fun addOrderDetailsToRoom(orderDetails: OrderDetail) {
        orderDetailsDao.insert(orderDetails)
    }

    override suspend fun updateOrderDetailsInRoom(orderDetails: OrderDetail) {
        orderDetailsDao.update(orderDetails)
    }

    override suspend fun deleteOrderDetailsFromRoom(orderId: Int, productId: Int, warehouseId: Int) {
        orderDetailsDao.delete(orderId, productId, warehouseId)
    }

}