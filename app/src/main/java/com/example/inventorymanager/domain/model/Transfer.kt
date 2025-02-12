package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import com.example.inventorymanager.domain.model.Product
import java.util.Date

@Entity(
    tableName = INVENTORY_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["originWarehouseId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["destinationWarehouseId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["productId"],
            childColumns = ["productId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["originWarehouseId"]), Index(value = ["destinationWarehouseId"])]
)
data class Transfer(
    @PrimaryKey(autoGenerate = true)
    val transferId: Int,
    val date: Date,
    val quantity: Int,
    val originWarehouseId: Int,
    val destinationWarehouseId: Int,
    val productId: Int
)
