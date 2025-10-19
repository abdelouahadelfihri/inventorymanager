package com.example.inventorymanager.domain.model.outgoings

import androidx.room.ForeignKey
import androidx.room.Entity
import androidx.room.Index
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_DETAILS_TABLE

@Entity(
    tableName = DELIVERY_DETAILS_TABLE,
    primaryKeys = ["salesOrderId", "productId", "warehouseId"],
    foreignKeys = [
        ForeignKey(entity = SalesOrder::class, parentColumns = ["deliveryId"], childColumns = ["deliveryId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Item::class, parentColumns = ["productId"], childColumns = ["productId"], onDelete = ForeignKey.CASCADE),
    ],
    indices = [Index(value = ["deliveryId"]), Index(value = ["productId"]), Index(value = ["warehouseId"])]
)
data class SalesOrderLine(
    val salesOrderId: Long,
    val productId: Long,
    val quantity: Double,
    val unitPrice: Double,
)