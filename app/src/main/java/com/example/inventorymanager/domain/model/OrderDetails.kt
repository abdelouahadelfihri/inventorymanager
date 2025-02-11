package com.example.inventory.domain.model

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.Product

@Entity(
    tableName = "order_details",
    primaryKeys = ["orderId", "productId"],
    foreignKeys = [
        ForeignKey(entity = Order::class, parentColumns = ["orderId"], childColumns = ["orderId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Product::class, parentColumns = ["productId"], childColumns = ["productId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["orderId"]), Index(value = ["productId"])]
)
data class OrderDetails(
    val orderId: Long,
    val productId: Long,
    val quantity: Int
)