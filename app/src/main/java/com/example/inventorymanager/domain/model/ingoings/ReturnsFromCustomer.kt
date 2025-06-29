package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.model.masterdata.Item
import com.example.inventorymanager.domain.model.outgoings.Customer
import java.util.Date

@Entity(
    tableName = ORDER_TABLE,
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = ["itemId"],
            childColumns = ["itemId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Warehouse::class,
            parentColumns = ["warehouseId"],
            childColumns = ["warehouseId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Customer::class,
            parentColumns = ["customerId"],
            childColumns = ["customerId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ReturnsFromCustomer(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var customerId: Int,
    var warehouseId: Int,
    val itemId: Int,
    val quantity: Int,
    val returnDate: Date,
    val reason: String
)