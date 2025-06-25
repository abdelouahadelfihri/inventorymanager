package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.Inventory
import com.example.inventorymanager.domain.model.Warehouse
import com.example.inventorymanager.domain.model.Item


data class WarehouseWithItems(
    @Embedded val warehouse: Warehouse,
    @Relation(
        parentColumn = "warehouseId",
        entityColumn = "itemId",
        associateBy = Junction(
            Inventory::class,
            parentColumn = "warehouseId",
            entityColumn = "itemId"
        )
    )
    val items: List<Item>
)