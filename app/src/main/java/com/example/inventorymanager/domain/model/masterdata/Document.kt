package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class Document (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val documentNumber: Int,
    val type: String,
    val referenceId: Int,
    val referenceType: String,
    val date : String,
    val status: String,
    val notes: String,
    val totalAmount: Double,
    val createdAt: String,
    val updatedAt: String
)