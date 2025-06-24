package com.example.inventorymanager.domain.model.ingoings

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.model.Warehouse

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