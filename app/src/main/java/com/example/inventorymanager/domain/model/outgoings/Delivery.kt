package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_TABLE


@Entity(
    tableName = DELIVERY_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = SalesOrder::class,
            parentColumns = ["id"],
            childColumns = ["salesOrderId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Customer::class,
            parentColumns = ["customerId"],
            childColumns = ["customerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Delivery(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val salesOrderId: Long?,   // optional link to sales order
    val deliveryDate: Long,
    val customerId: Long,
    val status: String // draft, validated
)