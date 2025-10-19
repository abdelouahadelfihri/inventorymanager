package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.SALES_ORDER_TABLE
import com.example.inventorymanager.domain.model.masterdata.Customer

@Entity(
    tableName = SALES_ORDER_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Customer::class,
            parentColumns = ["id"],
            childColumns = ["customerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["customerId"])]
)
data class SalesOrder(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val customerId: Long,
    val orderDate: Long,
    val status: String, // e.g., "draft", "confirmed", "delivered"
    val totalAmount: Double
)