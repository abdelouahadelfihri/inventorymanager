package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants

@Entity(tableName = Constants.Companion.CUSTOMER_TABLE)
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val customerId: Int,
    val name: String,
    val email: String,
    val phone: String,
    val mobile: String,
    val fax: String,
    val address: String
)