package com.example.inventorymanager.data.repository.ingoings

import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.data.dao.ingoings.OrderDao
import com.example.inventorymanager.domain.repository.ingoings.OrderRepository

class OrderRepositoryImpl(
    private val orderDao: OrderDao
) : OrderRepository {
    override fun getOrdersFromRoom() = orderDao.getOrders()

    override suspend fun getOrderFromRoom(id: Int) = orderDao.getOrder(id)

    override suspend fun addOrderToRoom(order: Order) = orderDao.addOrder(order)

    override suspend fun updateOrderInRoom(order: Order) = orderDao.updateOrder(order)

    override suspend fun deleteOrderFromRoom(id: Int) = orderDao.deleteOrder(id)

}