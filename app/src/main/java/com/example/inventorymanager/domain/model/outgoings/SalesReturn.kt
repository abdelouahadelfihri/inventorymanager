package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.RETURNS_FROM_CUSTOMER_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.model.outgoings.Customer
import java.util.Date

@Entity(
    tableName = RETURNS_FROM_CUSTOMER_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Customer::class,
            parentColumns = ["customerId"],
            childColumns = ["customerId"],
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
data class SalesReturn(
    @PrimaryKey(autoGenerate = true)
    val returnId: Int = 0,
    val customerId: Int,
    val warehouseId: Int,
    val returnDate: Date,
    val reason: String?
)