package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.Customer
import kotlinx.coroutines.flow.Flow
import com.example.inventorymanager.domain.common.Customers

interface CustomerRepository {

    fun getCustomersFromRoom(): Flow<Customers>

    suspend fun getCustomerFromRoom(id: Int): Customer

    suspend fun addCustomerToRoom(customer: Customer)

    suspend fun updateCustomerInRoom(customer: Customer)

    suspend fun deleteCustomerFromRoom(id: Int)

}