package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import com.example.inventorymanager.core.Constants.Companion.WAREHOUSE_TABLE

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
    val warehouseId: Int,
    val name: String,
    val isRefrigerated: Int,
    @ColumnInfo(index = true)
    val locationOwnerId: Int,
)