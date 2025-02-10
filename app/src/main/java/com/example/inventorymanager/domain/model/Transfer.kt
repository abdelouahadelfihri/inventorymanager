package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.ColumnInfo
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import java.util.Date

@Entity(
    tableName = "transfer",
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
        )
    ],
    indices = [Index(value = ["originWarehouseId"]), Index(value = ["destinationWarehouseId"])]
)
data class Transfer(
    @PrimaryKey(autoGenerate = true) val transferId: Long,
    val date: String,
    val quantity: Int,
    val originWarehouseId: Long,      // Foreign key to Warehouse (origin)
    val destinationWarehouseId: Long  // Foreign key to Warehouse (destination)
)
