package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_TABLE
import java.util.Date

@Entity(
    tableName = DELIVERY_TABLE,
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
data class Delivery(
    @PrimaryKey(autoGenerate = true)
    val deliveryId: Int,
    val customerId: Int,
    val saleDate: Date?
)