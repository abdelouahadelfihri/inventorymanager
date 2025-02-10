package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.WAREHOUSE_TABLE

@Entity(tableName = WAREHOUSE_TABLE)
data class Warehouse(
    @PrimaryKey(autoGenerate = true)
    val warehouseId: Long,
    val name: String,
    val isRefrigerated: Int
)