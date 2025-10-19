package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_RECEIPT_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import java.util.Date

@Entity(
    tableName = PURCHASE_RECEIPT_TABLE,
    foreignKeys = [
        ForeignKey(
        entity = PurchaseOrder::class,
        parentColumns = ["orderId"],
        childColumns = ["orderId"],
        onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Supplier::class,
            parentColumns = ["supplierId"],
            childColumns = ["supplierId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PurchaseReceipt(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val purchaseOrderId: Long?,
    val receiptDate: Long,
    val supplierId: Long,
    val status: String // e.g., "draft", "validated"
)