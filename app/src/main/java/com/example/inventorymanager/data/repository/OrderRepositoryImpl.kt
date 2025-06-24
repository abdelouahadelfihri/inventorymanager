package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.data.dao.OrderDao
import com.example.inventorymanager.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow

class OrderRepositoryImpl(
    private val orderDao: OrderDao
) : OrderRepository {
    override fun getOrdersFromRoom() = orderDao.getOrders()

    override suspend fun getOrderFromRoom(id: Int) = orderDao.getOrder(id)

    override suspend fun addOrderToRoom(order: Order) = orderDao.addOrder(order)

    override suspend fun updateOrderInRoom(order: Order) = orderDao.updateOrder(order)

    override suspend fun deleteOrderFromRoom(order: Order) = orderDao.deleteOrder(order)

    override fun searchOrders(query: String): Flow<List<Order>> {
        return orderDao.searchOrders("%$query%")
    }
}