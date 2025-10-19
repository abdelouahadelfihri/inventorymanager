package com.example.inventorymanager.domain.common

import com.example.inventorymanager.domain.model.outgoings.Customer
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.model.masterdata.Category
import com.example.inventorymanager.domain.model.outgoings.SalesOrder

typealias Customers = List<Customer>
typealias Deliveries = List<SalesOrder>
typealias Orders = List<Order>
typealias Categories = List<Category>
