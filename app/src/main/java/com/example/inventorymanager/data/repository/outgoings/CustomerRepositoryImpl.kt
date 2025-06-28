package com.example.inventorymanager.data.repository.outgoings

import com.example.inventorymanager.data.dao.outgoings.CustomerDao
import com.example.inventorymanager.domain.model.outgoings.Customer
import com.example.inventorymanager.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.Flow

class CustomerRepositoryImpl(
    private val customerDao: CustomerDao
) : CustomerRepository {

    override fun getCustomersFromRoom() = customerDao.getCustomers()

    override suspend fun getCustomerFromRoom(id: Int) = customerDao.getCustomer(id)

    override suspend fun addCustomerToRoom(customer: Customer) = customerDao.addCustomer(customer)

    override suspend fun updateCustomerInRoom(customer: Customer) = customerDao.updateCustomer(customer)

    override suspend fun deleteCustomerFromRoom(id: Int) = customerDao.deleteCustomer(id)

}