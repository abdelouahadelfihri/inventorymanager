package com.example.inventorymanager.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_TABLE
import java.time.LocalDateTime

@Entity(tableName = PRODUCT_TABLE)
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