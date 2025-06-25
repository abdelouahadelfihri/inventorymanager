package com.example.inventorymanager.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_TABLE

@Entity(tableName = PRODUCT_TABLE)
data class Category (
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val name: String,
    val description: String
)