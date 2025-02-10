package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.domain.model.Provider
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import java.util.Date

@Entity(
    tableName = ORDER_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Provider::class,
            parentColumns = ["idd"],
            childColumns = ["providerId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["providerId"])]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Long,
    val orderDate: Date,
    val providerId: Long  // Foreign key referencing Provider
)