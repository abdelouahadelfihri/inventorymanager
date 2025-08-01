package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.UNIT_TABLE

@Entity(tableName = UNIT_TABLE)
data class MeasurementUnit(
    @PrimaryKey(autoGenerate = true)
    val unitId: Int,
    val name: String,
    val abbreviation: String
)