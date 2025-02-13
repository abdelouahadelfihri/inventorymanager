package com.example.inventorymanager.data.dao

import androidx.room.Transaction
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.inventory.domain.model.Delivery
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.domain.relationshipdataclasses.CustomerWithDeliveries
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TABLE
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_TABLE

@Dao
interface CustomerDao {

    // Insert a customer and return the generated ID
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer): Long

    // Insert a delivery (customerId can be null, allowing unassigned deliveries)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDelivery(delivery: Delivery): Long

    // Get all customers
    @Query("SELECT * FROM $CUSTOMER_TABLE")
    suspend fun getAllCustomers(): List<Customer>

    // Get all deliveries
    @Query("SELECT * FROM $DELIVERY_TABLE")
    suspend fun getAllDeliveries(): List<Delivery>

    // Get all deliveries for a specific customer
    @Query("SELECT * FROM $DELIVERY_TABLE WHERE customerId = :customerId")
    suspend fun getDeliveriesForCustomer(customerId: Long): List<Delivery>

    // Get a customer with their deliveries using a Room relation
    @Transaction
    @Query("SELECT * FROM $CUSTOMER_TABLE WHERE customerId = :customerId")
    suspend fun getCustomerWithDeliveries(customerId: Long): CustomerWithDeliveries?

    // Delete a customer (CASCADE will delete deliveries if configured in the entity)
    @Delete
    suspend fun deleteCustomer(customer: Customer)

    // Delete a delivery
    @Delete
    suspend fun deleteDelivery(delivery: Delivery)
}