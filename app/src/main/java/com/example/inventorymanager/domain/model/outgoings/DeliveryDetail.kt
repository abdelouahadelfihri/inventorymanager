package com.example.inventorymanager.domain.model.outgoings

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_DETAILS_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@Entity(
    tableName = DELIVERY_DETAILS_TABLE,
    primaryKeys = ["deliveryId", "productId", "warehouseId"],
    foreignKeys = [
        ForeignKey(entity = Delivery::class, parentColumns = ["deliveryId"], childColumns = ["deliveryId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Item::class, parentColumns = ["productId"], childColumns = ["productId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Warehouse::class, parentColumns = ["warehouseId"], childColumns = ["warehouseId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index(value = ["deliveryId"]), Index(value = ["productId"]), Index(value = ["warehouseId"])]
)
data class DeliveryDetail(
    val deliveryId: Int,
    val productId: Int,
    val warehouseId: Int,
    val quantity: Int
)