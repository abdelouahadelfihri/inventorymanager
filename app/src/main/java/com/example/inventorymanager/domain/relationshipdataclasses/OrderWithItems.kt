package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.model.Item
import com.example.inventorymanager.domain.model.ingoings.OrderDetails

data class OrderWithItems(
    @Embedded val order: Order,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "productId",
        associateBy = Junction(OrderDetails::class)
    )
    val items: List<Item>
)