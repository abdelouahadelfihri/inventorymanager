package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE

@Entity(tableName = INVENTORY_TABLE)
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val quantityAvailable: Int,
    val minimumStockLevel: Int,
    val maximumStockLevel: Int,
    val reorderPoint: Int
)