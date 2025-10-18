package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import java.util.Date

@Entity(
    tableName = ORDER_TABLE,
    foreignKeys = [ForeignKey(
        entity = Supplier::class,
        parentColumns = ["providerId"],
        childColumns = ["providerId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val orderId: Int,
    val providerId: Int,
    val orderDate: Date?
)