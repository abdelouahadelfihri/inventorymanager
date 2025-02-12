package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.model.Provider
import java.util.Date

@Entity(
    tableName = ORDER_TABLE,
    foreignKeys = [ForeignKey(
        entity = Provider::class,
        parentColumns = ["providerId"],
        childColumns = ["providerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int,
    val providerId: Int,
    val orderDate: Date
)