package com.example.inventorymanager.domain.relationshipdataclasses

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrderLine
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrder
import com.example.inventorymanager.domain.model.masterdata.Item

data class ItemWithOrders(
    @Embedded val item: Item,
    @Relation(
        parentColumn = "itemId",
        entityColumn = "orderId",
        associateBy = Junction(PurchaseOrderLine::class)
    )
    val orders: List<PurchaseOrder>
)
