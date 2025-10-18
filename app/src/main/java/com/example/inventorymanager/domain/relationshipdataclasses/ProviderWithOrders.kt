package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventory.domain.model.Order
import com.example.inventorymanager.domain.model.ingoings.Supplier


data class ProviderWithOrders(
    @Embedded val provider: Supplier,
    @Relation(
        parentColumn = "providerId",
        entityColumn = "providerId"
    )
    val orders: List<Order>
)
