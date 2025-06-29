package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.SALE_RECEIPT_DETAILS_TABLE
import com.example.inventorymanager.domain.model.masterdata.Item
import java.util.Date

@Entity(
    tableName = SALE_RECEIPT_DETAILS_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = SaleReceipt::class,
            parentColumns = ["categoryId"],
            childColumns = ["category"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["itemId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["category"]),
        Index(value = ["unit"])
    ]
)

data class SaleReceiptDetail(
    val id: Int,
    val salesReceiptId: Int,   // Foreign key to SalesReceipt
    val productId: Int,        // Foreign key to Product
    val quantity: Double,
    val unitPrice: Double,
    val discount: Double = 0.0,
    val taxRate: Double = 0.0, // Optional if your app uses taxes
    val total: Double,         // Usually: (unitPrice * quantity - discount) + tax
    val deliveredDate: Date?,  // Optional: when the product was actually delivered
    val storageBin: String?    // Optional: bin in warehouse where it was picked
)