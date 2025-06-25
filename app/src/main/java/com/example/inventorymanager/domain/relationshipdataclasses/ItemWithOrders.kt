package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.ingoings.OrderDetails
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.model.Item

data class ItemWithOrders(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "orderId",
        associateBy = Junction(OrderDetails::class)
    )
    val orders: List<Order>
)
