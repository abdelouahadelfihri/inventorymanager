package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class DocumentLine (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val documentId: Int,
    val productId: Int,
    val quantity: Int,
    val unitPrice: Double
)