package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventory.domain.model.Order
import com.example.inventory.domain.model.OrderDetails
import com.example.inventorymanager.domain.model.Product

data class ProductWithOrders(
    @Embedded val product: Product,
    @Relation(
        parentColumn = "productId",
        entityColumn = "orderId",
        associateBy = Junction(OrderDetails::class)
    )
    val orders: List<Order>
)
