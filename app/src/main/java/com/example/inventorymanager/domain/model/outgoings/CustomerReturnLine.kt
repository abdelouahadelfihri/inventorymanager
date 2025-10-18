package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.RETURNS_FROM_CUSTOMER_LINES_TABLE
import com.example.inventorymanager.domain.model.masterdata.Product

@Entity(
    tableName = RETURNS_FROM_CUSTOMER_LINES_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = CustomerReturn::class,
            parentColumns = ["returnId"],
            childColumns = ["returnId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Product::class,
            parentColumns = ["itemId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class CustomerReturnLine(
    @PrimaryKey(autoGenerate = true)
    val lineId: Int = 0,
    val returnId: Int,
    val itemId: Int,
    val quantity: Int
)