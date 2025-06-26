package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.ITEM_TABLE
import com.example.inventorymanager.domain.model.Category
import com.example.inventorymanager.domain.model.Unit
import java.util.Date

@Entity(
    tableName = ITEM_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["category"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Unit::class,
            parentColumns = ["unitId"],
            childColumns = ["unit"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["category"]),
        Index(value = ["unit"])
    ]
)

data class PurchaseReceiptDetail(
    val id: Int,
    val purchaseReceiptId: Int,
    val productId: Int,
    val quantity: Double,
    val unitPrice: Double,
    val discount: Double = 0.0,
    val total: Double,
    val storageBin: String?, // Optional
    val receivedDate: Date
)
