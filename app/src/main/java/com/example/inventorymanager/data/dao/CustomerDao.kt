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

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCustomer(customer: Customer): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDelivery(delivery: Delivery): Long

    @Transaction
    @Query("SELECT * FROM $CUSTOMER_TABLE WHERE customerId = :customerId")
    suspend fun getCustomerWithDeliveries(customerId: Int): CustomerWithDeliveries?

}