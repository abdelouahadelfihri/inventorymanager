package com.example.inventorymanager.domain.model

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "order_details",
    primaryKeys = ["orderId", "productId","warehouseId"],
    foreignKeys = [
        ForeignKey(entity = Order::class, parentColumns = ["orderId"], childColumns = ["orderId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Product::class, parentColumns = ["productId"], childColumns = ["productId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Warehouse::class, parentColumns = ["warehouseId"], childColumns = ["warehouseId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["orderId"]), Index(value = ["productId"]), Index(value = ["warehouseId"])]
)
data class OrderDetails(
    val orderId: Int,
    val productId: Int,
    val warehouseId: Int,
    val quantity: Int
)