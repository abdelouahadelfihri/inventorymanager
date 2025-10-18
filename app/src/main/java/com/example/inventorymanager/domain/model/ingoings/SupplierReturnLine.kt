package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.RETURNS_TO_SUPPLIER_LINES_TABLE
import com.example.inventorymanager.domain.model.masterdata.Item

@Entity(
    tableName = RETURNS_TO_SUPPLIER_LINES_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = SupplierReturn::class,
            parentColumns = ["returnId"],
            childColumns = ["returnId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Item::class,
            parentColumns = ["itemId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SupplierReturnLine(
    @PrimaryKey(autoGenerate = true)
    val lineId: Int = 0,
    val returnId: Int,
    val itemId: Int,
    val quantity: Int
)