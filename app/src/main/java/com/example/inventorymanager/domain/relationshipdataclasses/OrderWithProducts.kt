package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventory.domain.model.Order
import com.example.inventorymanager.domain.model.Product
import com.example.inventory.domain.model.OrderDetails

data class OrderWithProducts(
    @Embedded val order: Order,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "productId",
        associateBy = Junction(OrderDetails::class)
    )
    val products: List<Product>
)