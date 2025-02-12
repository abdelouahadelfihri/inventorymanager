package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventory.domain.model.Inventory
import com.example.inventory.domain.model.Warehouse
import com.example.inventorymanager.domain.model.Product


data class WarehouseWithProducts(
    @Embedded val warehouse: Warehouse,
    @Relation(
        parentColumn = "warehouseId",
        entityColumn = "productId",
        associateBy = Junction(
            Inventory::class,
            parentColumn = "warehouse_id",
            entityColumn = "product_id"
        )
    )
    val products: List<Product>
)