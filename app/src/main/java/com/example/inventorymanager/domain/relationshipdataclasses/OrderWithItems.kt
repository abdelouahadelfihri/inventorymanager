package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrder
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrderLine

data class OrderWithItems(
    @Embedded val order: PurchaseOrder,
    @Relation(
        parentColumn = "orderId",
        entityColumn = "productId",
        associateBy = Junction(PurchaseOrderLine::class)
    )
    val items: List<Item>
)