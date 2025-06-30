package com.example.inventorymanager.domain.repository.outgoings

import com.example.inventorymanager.domain.common.Customers
import com.example.inventorymanager.domain.model.outgoings.Customer
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {

    fun getCustomersFromRoom(): Flow<Customers>

    suspend fun getCustomerFromRoom(id: Int): Customer

    suspend fun addCustomerToRoom(customer: Customer)

    suspend fun updateCustomerInRoom(customer: Customer)

    suspend fun deleteCustomerFromRoom(id: Int)

}