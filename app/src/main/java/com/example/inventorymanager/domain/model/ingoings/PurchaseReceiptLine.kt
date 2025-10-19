package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_RECEIPT_DETAIL_TABLE
import com.example.inventorymanager.domain.model.masterdata.Item
import java.util.Date

@Entity(
    tableName = PURCHASE_RECEIPT_LINE_TABLE,
    primaryKeys = ["purchaseReceiptId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = PurchaseReceipt::class,
            parentColumns = ["purchaseReceiptId"],
            childColumns = ["purchaseReceiptId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["itemId"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["itemId"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["purchaseReceiptId"]),
        Index(value = ["productId"])
    ]
)
data class PurchaseReceiptLine(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val purchaseReceiptId: Long,
    val productId: Long,
    val quantity: Double,
    val warehouseId: Long
)