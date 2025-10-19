package com.example.inventorymanager.data.dao.outgoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.common.Customers
import com.example.inventorymanager.domain.model.masterdata.Customer
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomerDao {

    @Query("SELECT * FROM ${Constants.Companion.CUSTOMER_TABLE} ORDER BY customerId ASC")
    fun getCustomers(): Flow<Customers>

    @Query("SELECT * FROM ${Constants.Companion.CUSTOMER_TABLE} WHERE customerId = :id")
    suspend fun getCustomer(id: Int): Customer

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addCustomer(order: Customer)

    @Update
    suspend fun updateCustomer(order: Customer)

    @Delete
    suspend fun deleteCustomer(id: Int)

}