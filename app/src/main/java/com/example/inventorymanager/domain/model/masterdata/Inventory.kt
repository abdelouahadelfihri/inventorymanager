package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE

@Entity(
    tableName = INVENTORY_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["productId"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["warehouseId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["product_id"]), Index(value = ["warehouse_id"])]
)
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val inventoryId: Int,
    val quantityAvailable: Int,
    val minimumStockLevel: Int,
    val maximumStockLevel: Int,
    val reorderPoint: Int,
    @ColumnInfo(name = "productId") val productId: Int,
    @ColumnInfo(name = "warehouseId") val warehouseId: Int,
)