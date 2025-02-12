package com.example.inventory.domain.model

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_DETAILS_TABLE

@Entity(
    tableName = DELIVERY_DETAILS_TABLE,
    primaryKeys = ["deliveryId", "productId", "warehouseId"],
    foreignKeys = [
        ForeignKey(entity = Delivery::class, parentColumns = ["deliveryId"], childColumns = ["deliveryId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Product::class, parentColumns = ["productId"], childColumns = ["productId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Warehouse::class, parentColumns = ["warehouseId"], childColumns = ["warehouseId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["deliveryId"]), Index(value = ["productId"]), Index(value = ["warehouseId"])]
)
data class DeliveryDetails(
    val deliveryId: Long,
    val productId: Long,
    val warehouseId: Long,
    val quantity: Int
)