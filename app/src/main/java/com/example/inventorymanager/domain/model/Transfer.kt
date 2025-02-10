package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import java.util.Date

@Entity(tableName = INVENTORY_TABLE)
data class Transfer(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val wareHouseOrigin: Int,
    val wareHouseDestination: Int,
    val transferQuantity: Int,
    val dispatchDate: Date,
    val receiptDate: Date
)