package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE

@Entity(
    tableName = ORDER_TABLE,
    foreignKeys = [ForeignKey(
        entity = Supplier::class,
        parentColumns = ["supplierId"],
        childColumns = ["providerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class PurchaseOrder(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val supplierId: Long,
    val orderDate: Long,
    val status: String, // draft, confirmed, received
    val totalAmount: Double
)