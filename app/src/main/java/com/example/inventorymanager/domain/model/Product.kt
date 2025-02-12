package com.example.inventorymanager.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_TABLE

@Entity(tableName = PRODUCT_TABLE)
data class Product(
    @PrimaryKey(autoGenerate = true)
    val productId: Int,
    val code: String,
    val barCode: String,
    val name: String,
    val description: String,
    val category: String,
    val reorderQuantity: Int,
    val reorderLevel: Int,
    val packedWeight: Double,
    val packedHeight: Double,
    val packedWidth: Double,
    val packedDepth: Double,
    val refrigerated: Boolean
)