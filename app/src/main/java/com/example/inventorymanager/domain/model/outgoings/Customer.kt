package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants

@Entity(tableName = Constants.Companion.CUSTOMER_TABLE)
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val customerId: Int,
    val name: String,
    val address: String,
    val email: String,
    val phone: String,
    val taxId: String,
    val bankDetails: String,
    val notes: String,
    val discount: Double
)