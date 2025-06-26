package com.example.inventorymanager.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_TABLE
import java.time.LocalDateTime

@Entity(
    tableName = ITEM_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["categoryId"],
            childColumns = ["categoryid"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Unit::class,
            parentColumns = ["unitId"],
            childColumns = ["unitId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["product_id"]), Index(value = ["warehouse_id"])]
)
data class Item(
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val code: String,
    val barCode: String,
    val name: String,
    val sku: String,
    val category: Int,
    val unit: Int,
    val description: String,
    val reorderQuantity: Int,
    val reorderLevel: Int,
    val packedWeight: Double,
    val packedHeight: Double,
    val packedWidth: Double,
    val packedDepth: Double,
    val refrigerated: Boolean,
    val isActive: Boolean,
    val createdAt: LocalDateTime, // ✅ this is the DateTime field
)