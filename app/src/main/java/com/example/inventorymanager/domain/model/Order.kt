package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import java.util.Date

@Entity(tableName = ORDER_TABLE)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val orderDate: Date,
    @ColumnInfo(name = "provider_id") val idProvider: Int
)