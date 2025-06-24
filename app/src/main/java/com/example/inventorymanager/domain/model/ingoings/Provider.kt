package com.example.inventorymanager.domain.model.ingoings

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.inventorymanager.core.Constants.Companion.PROVIDER_TABLE

@Entity(tableName = PROVIDER_TABLE)
data class Provider(
    @PrimaryKey(autoGenerate = true)
    val providerId: Int,
    val name: String,
    val address: String
)