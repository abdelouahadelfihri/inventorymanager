package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventory.domain.model.Order
import com.example.inventory.domain.model.OrderDetails
import com.example.inventorymanager.domain.model.Item

data class ProductWithOrders(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "productId",
        entityColumn = "orderId",
        associateBy = Junction(OrderDetails::class)
    )
    val orders: List<Order>
)
