package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.SALE_RECEIPT_DETAIL_TABLE
import com.example.inventorymanager.domain.model.masterdata.Item
import java.util.Date

@Entity(
    tableName = SALE_RECEIPT_DETAIL_TABLE,
    primaryKeys = ["saleReceiptId", "productId"],
    foreignKeys = [
        ForeignKey(
            entity = SaleReceipt::class,
            parentColumns = ["saleReceiptId"],
            childColumns = ["saleReceiptId"],
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
        Index(value = ["saleReceiptId"]),
        Index(value = ["productId"])
    ]
)

data class SaleReceiptDetail(
    val saleReceiptId: Int,
    val productId: Int,
    val quantity: Double,
    val unitPrice: Double,
    val discount: Double = 0.0,
    val taxRate: Double = 0.0,
    val total: Double,
    val deliveredDate: Date?,
    val storageBin: String?
)