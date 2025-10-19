package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventory.domain.model.Delivery
import com.example.inventorymanager.domain.model.masterdata.Customer

data class CustomerWithDeliveries(
    @Embedded val customer: Customer,

    @Relation(
        parentColumn = "customerId",
        entityColumn = "customerId"
    )
    val deliveries: List<Delivery>
)