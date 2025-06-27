package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.masterdata.Inventory
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.model.masterdata.Item


data class ItemWithWarehouses(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "warehouseId",
        associateBy = Junction(
            Inventory::class,
            parentColumn = "product_id",
            entityColumn = "warehouse_id"
        )
    )
    val warehouses: List<Warehouse>
)
