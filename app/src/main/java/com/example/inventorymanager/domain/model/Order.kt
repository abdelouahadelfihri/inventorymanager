package com.example.inventory.domain.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.domain.model.Provider
import java.util.Date

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
    val orderId: Int = 0,
    val providerId: Int?, // Nullable to allow unassigned orders
    val orderDate: Date
)
