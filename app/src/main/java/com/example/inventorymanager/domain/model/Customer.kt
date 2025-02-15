package com.example.inventorymanager.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TABLE


@Entity(tableName = CUSTOMER_TABLE)
data class Customer(
    @PrimaryKey(autoGenerate = true)
    val customerId: Int,
    val name: String,
    val address: String
)