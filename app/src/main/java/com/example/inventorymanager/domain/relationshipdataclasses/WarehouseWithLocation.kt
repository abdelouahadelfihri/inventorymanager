package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.domain.model.masterdata.Warehouse

data class WarehouseWithLocation(
    @Embedded val warehouse: Warehouse,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "locationOwnerId"
    )
    val location: Location
)
