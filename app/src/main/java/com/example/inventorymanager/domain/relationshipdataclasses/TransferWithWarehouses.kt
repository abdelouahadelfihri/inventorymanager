package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import com.example.inventory.domain.model.Transfer
import com.example.inventory.domain.model.Warehouse


data class TransferWithWarehouses(
    @Embedded val transfer: Transfer,

    @Relation(
        parentColumn = "originWarehouseId",
        entityColumn = "warehouseId"
    )
    val originWarehouse: Warehouse,

    @Relation(
        parentColumn = "destinationWarehouseId",
        entityColumn = "warehouseId"
    )
    val destinationWarehouse: Warehouse
)