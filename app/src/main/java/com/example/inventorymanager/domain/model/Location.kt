package com.example.inventorymanager.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.LOCATION_TABLE

@Entity(tableName = LOCATION_TABLE)
data class Location(
    @PrimaryKey(autoGenerate = true)
    val locationId: Int,
    val name: String,
    val address: String
)