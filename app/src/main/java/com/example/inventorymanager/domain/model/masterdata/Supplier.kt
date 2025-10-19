package com.example.inventorymanager.domain.model.masterdata

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants

@Entity(tableName = Constants.Companion.PROVIDER_TABLE)
data class Supplier(
    @PrimaryKey(autoGenerate = true)
    val providerId: Int,
    val name: String,
    val address: String,
    val email: String,
    val phone: String,
    val taxId: String,
    val bankDetails: String,
    val notes: String
)