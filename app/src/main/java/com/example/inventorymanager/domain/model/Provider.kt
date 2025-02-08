package ro.alexmamo.roomjetpackcompose.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ro.alexmamo.roomjetpackcompose.core.Constants.Companion.PROVIDER_TABLE

@Entity(tableName = PROVIDER_TABLE)
data class Provider(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val address: String
)