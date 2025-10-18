package com.example.inventorymanager.domain.model.outgoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.RETURNS_TO_SUPPLIER_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.model.ingoings.Supplier
import java.util.Date

@Entity(
    tableName = RETURNS_TO_SUPPLIER_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Supplier::class,
            parentColumns = ["supplierId"],
            childColumns = ["supplierId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["warehouseId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SupplierReturn(
    @PrimaryKey(autoGenerate = true)
    val returnId: Int = 0,
    val supplierId: Int,
    val warehouseId: Int,
    val returnDate: Date,
    val reason: String?
)