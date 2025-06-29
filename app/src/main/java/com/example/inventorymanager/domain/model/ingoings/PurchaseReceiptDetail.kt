package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_RECEIPT_DETAIL_TABLE
import com.example.inventorymanager.domain.model.masterdata.Item
import java.util.Date

@Entity(
    tableName = PURCHASE_RECEIPT_DETAIL_TABLE,
    primaryKeys = ["purchaseReceiptId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = PurchaseReceipt::class,
            parentColumns = ["purchaseReceiptId"],
            childColumns = ["purchaseReceiptId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
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
data class PurchaseReceiptDetail(
    val purchaseReceiptId: Int,
    val productId: Int,
    val quantity: Double,
    val unitPrice: Double,
    val discount: Double = 0.0,
    val total: Double,
    val storageBin: String?,
    val receivedDate: Date
)