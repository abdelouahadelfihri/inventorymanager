package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TABLE
import com.example.inventorymanager.domain.common.Customers
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Query("SELECT * FROM $CUSTOMER_TABLE ORDER BY customerId ASC")
    fun getCustomers(): Flow<Customers>

    @Query("SELECT * FROM $CUSTOMER_TABLE WHERE customerId = :id")
    suspend fun getCustomer(id: Int): Customer

    @Insert(onConflict = IGNORE)
    suspend fun addCustomer(order: Customer)

    @Update
    suspend fun updateCustomer(order: Customer)

    @Delete
    suspend fun deleteCustomer(id: Int)

}