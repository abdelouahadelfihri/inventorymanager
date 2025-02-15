package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Update
import androidx.room.OnConflictStrategy
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TABLE



@Dao
interface CustomerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(customer: Customer)

    @Update
    suspend fun update(customer: Customer)

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM $CUSTOMER_TABLE")
    suspend fun getCustomers(): List<Customer>

    @Query("SELECT * FROM $CUSTOMER_TABLE WHERE customerId = :id")
    suspend fun getCustomerById(id: Int): Customer?
}
