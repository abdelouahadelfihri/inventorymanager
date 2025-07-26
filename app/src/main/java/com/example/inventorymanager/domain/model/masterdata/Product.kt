package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.ITEM_TABLE
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
data class Product(
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
    val createdAt: LocalDateTime,
)