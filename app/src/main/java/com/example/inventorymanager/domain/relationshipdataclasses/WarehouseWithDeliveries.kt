package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventory.domain.model.Warehouse
import com.example.inventory.domain.model.DeliveryDetails

data class WarehouseWithDeliveries(
    @Embedded val warehouse: Warehouse,
    @Relation(
        parentColumn = "warehouseId",
        entityColumn = "warehouseId"
    )
    val deliveryDetails: List<DeliveryDetails>
)