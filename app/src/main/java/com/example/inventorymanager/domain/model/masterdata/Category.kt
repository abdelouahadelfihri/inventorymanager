package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.CATEGORY_TABLE

@Entity(tableName = CATEGORY_TABLE)
data class Category (
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val name: String,
    val description: String
)