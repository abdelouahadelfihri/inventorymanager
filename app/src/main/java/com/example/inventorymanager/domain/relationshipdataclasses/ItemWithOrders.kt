package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.ingoings.OrderDetail
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.model.masterdata.Item

data class ItemWithOrders(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "orderId",
        associateBy = Junction(OrderDetail::class)
    )
    val orders: List<Order>
)
