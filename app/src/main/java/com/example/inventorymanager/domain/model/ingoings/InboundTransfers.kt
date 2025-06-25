package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_TABLE
import java.util.Date

@Entity(tableName = PRODUCT_TABLE)
data class InboundTransfers(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val fromWarehouseId: Int,
    val toWarehouseId: Int,
    val item: String,
    val quantity: Int,
    val transferDate: Date
)