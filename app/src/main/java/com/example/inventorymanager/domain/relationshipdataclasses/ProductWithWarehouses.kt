package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventory.domain.model.Inventory
import com.example.inventory.domain.model.Warehouse
import com.example.inventorymanager.domain.model.Item


data class ProductWithWarehouses(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "productId",
        entityColumn = "warehouseId",
        associateBy = Junction(
            Inventory::class,
            parentColumn = "product_id",
            entityColumn = "warehouse_id"
        )
    )
    val warehouses: List<Warehouse>
)
