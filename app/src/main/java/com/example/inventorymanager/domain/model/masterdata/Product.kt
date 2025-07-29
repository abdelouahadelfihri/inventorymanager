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
    val name: String,
    val code: String,
    val barCode: String,
    val category: Int,
    val unit: Int,
    val reorderLevel: Int,
    val isActive: Boolean
)