package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

import com.example.inventorymanager.domain.model.Category
import com.example.inventorymanager.domain.model.Unit
import java.time.LocalDateTime


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
    val id: Int, // Primary key
    val purchaseReceiptId: Int, // FK to PurchaseReceipt
    val productId: Int, // FK to Product
    val quantity: Double,
    val unitPrice: Double,
    val discount: Double = 0.0,
    val total: Double, // Computed: quantity * unitPrice - discount
    val warehouseLocation: String?, // Optional shelf/bin/etc.
    val receivedDate: LocalDateTime
)
