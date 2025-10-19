package com.example.inventorymanager.domain.model.outgoings

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_ORDER_LINE_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@Entity(
    tableName = PURCHASE_ORDER_LINE_TABLE,
    primaryKeys = ["purchaseOrderId", "productId", "warehouseId"],
    foreignKeys = [
        ForeignKey(
            entity = SalesOrder::class,
            parentColumns = ["id"],
            childColumns = ["purchaseOrderId"],
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
        Index(value = ["purchaseOrderId"]),
        Index(value = ["productId"]),
        Index(value = ["warehouseId"])
    ]
)
data class PurchaseOrderLine(
    val purchaseOrderId: Long,
    val productId: Long,
    val warehouseId: Long,
    val quantity: Double,
    val unitPrice: Double
)