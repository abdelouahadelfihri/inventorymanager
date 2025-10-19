package com.example.inventorymanager.domain.model.outgoings

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.core.Constants.Companion.SALES_ORDER_LINE_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@Entity(
    tableName = SALES_ORDER_LINE_TABLE,
    primaryKeys = ["salesOrderId", "productId", "warehouseId"],
    foreignKeys = [
        ForeignKey(
            entity = SalesOrder::class,
            parentColumns = ["id"],
            childColumns = ["salesOrderId"],
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
        Index(value = ["salesOrderId"]),
        Index(value = ["productId"]),
        Index(value = ["warehouseId"])
    ]
)
data class SalesOrderLine(
    val salesOrderId: Long,
    val productId: Long,
    val warehouseId: Long,
    val quantity: Double,
    val unitPrice: Double
)