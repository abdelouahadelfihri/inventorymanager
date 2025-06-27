package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventory.domain.model.Warehouse
import com.example.inventorymanager.domain.model.masterdata.Location

data class LocationWithWarehouses(
    @Embedded val location: Location,
    @Relation(
        parentColumn = "locationId",
        entityColumn = "locationOwnerId"
    )
    val warehouses: List<Warehouse>
)
