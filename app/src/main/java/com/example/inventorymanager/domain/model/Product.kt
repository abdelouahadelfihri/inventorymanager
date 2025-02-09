package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.PROVIDER_TABLE

@Entity(tableName = PROVIDER_TABLE)
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val code: String,
    val barCode: String,
    val name: String,
    val description: String,
    val category: String,
    val reorderQuantity: Int,
    val reorderLevel: Int,
    val packedWeight: Double,
    val packedHeight: Double,
    val packedWidth: Double,
    val packedDepth: Double,
    val refrigerated: Boolean
)