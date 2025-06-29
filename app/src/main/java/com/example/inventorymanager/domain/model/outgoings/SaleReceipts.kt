package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.SALE_RECEIPT_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.model.ingoings.Order
import java.util.Date

@Entity(
    tableName = SALE_RECEIPT_TABLE,
    foreignKeys = [
        ForeignKey(
        entity = Order::class,
        parentColumns = ["orderId"],
        childColumns = ["orderId"],
        onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["warehouseId"],
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
data class SaleReceipts(
    @PrimaryKey(autoGenerate = true)
    val saleReceiptId: Int,
    var orderId: Int,
    val customerId: Int,
    val wareHouseId: Int,
    val receiptDate: Date,
    val deliveredBy: String,
    val totalAmount: Double,
    val notes: String,
    val status: String
)