package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.PROVIDER_TABLE

@Entity(tableName = PROVIDER_TABLE)
data class Inventory(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val quantityAvailable: Int,
    val minimumStockLevel: Int,
    val maximumStockLevel: Int,
    val reorderPoint: Int
)