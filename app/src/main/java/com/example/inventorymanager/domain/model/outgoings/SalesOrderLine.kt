package com.example.inventorymanager.domain.model.outgoings

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.core.Constants.Companion.SALES_ORDER_LINE_TABLE

@Entity(
    tableName = SALES_ORDER_LINE_TABLE,
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
        )]
)
data class SalesOrderLine(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val salesOrderId: Long,
    val productId: Long,
    val quantity: Double,
    val unitPrice: Double,
    val totalPrice: Double
)