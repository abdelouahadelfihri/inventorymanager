package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_LINE_TABLE
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@Entity(
    tableName = DELIVERY_LINE_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Delivery::class,
            parentColumns = ["id"],
            childColumns = ["deliveryId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["id"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["id"],
            childColumns = ["warehouseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["deliveryId"]),
        Index(value = ["productId"]),
        Index(value = ["warehouseId"])
    ]
)
data class DeliveryLine(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val deliveryId: Long,
    val productId: Long,
    val quantity: Double,
    val warehouseId: Long
)