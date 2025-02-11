package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import androidx.room.Index
import com.example.inventorymanager.domain.model.Provider
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE

@Entity(
    tableName = "orders",
    foreignKeys = [ForeignKey(
        entity = Provider::class,
        parentColumns = ["providerId"],
        childColumns = ["providerId"],
        onDelete = ForeignKey.SET_NULL // If a provider is deleted, the orders remain with a NULL providerId
    )]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Long = 0,
    val providerId: Long?, // Nullable to allow unassigned orders
    val description: String
)
