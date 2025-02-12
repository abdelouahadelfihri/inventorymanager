package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import com.example.inventorymanager.core.Constants.Companion.WAREHOUSE_TABLE
import com.example.inventorymanager.domain.model.Location

@Entity(
    tableName = WAREHOUSE_TABLE,
    foreignKeys = [ForeignKey(
        entity = Location::class,
        parentColumns = ["locationId"],
        childColumns = ["locationOwnerId"],
        onDelete = ForeignKey.CASCADE // Deletes warehouses when location is deleted
    )]
)
data class Warehouse(
    @PrimaryKey(autoGenerate = true)
    val warehouseId: Long,
    val name: String,
    val isRefrigerated: Int,
    @ColumnInfo(index = true) // Index improves query performance
    val locationOwnerId: Long,  // Foreign key linking to Location
)