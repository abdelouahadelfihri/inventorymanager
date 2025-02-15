package com.example.inventorymanager.domain.repository

import com.example.inventory.domain.model.Inventory
import kotlinx.coroutines.flow.Flow


typealias Customers = List<Inventory>

interface CustomerRepository {

    fun getCustomersFromRoom(): Flow<Customers>

    suspend fun getCustomerFromRoom(id: Int): Customer

    suspend fun addCustomerToRoom(customer: Customer)

    suspend fun updateCustomerInRoom(customer: Customer)

    suspend fun deleteCustomerFromRoom(customer: Customer)

}