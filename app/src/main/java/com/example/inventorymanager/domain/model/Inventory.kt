package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.ColumnInfo
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import com.example.inventorymanager.domain.model.Product

@Entity(
    tableName = INVENTORY_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Product::class,
            parentColumns = ["productId"],
            childColumns = ["product_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["warehouse_id"],
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
    @ColumnInfo(name = "product_id") val productId: Int,
    @ColumnInfo(name = "warehouse_id") val warehouseId: Int,
)