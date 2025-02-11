package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventory.domain.model.Order
import com.example.inventorymanager.domain.model.Provider


data class ProviderWithOrders(
    @Embedded val provider: Provider,
    @Relation(
        parentColumn = "providerId",
        entityColumn = "providerId"
    )
    val orders: List<Order>
)
