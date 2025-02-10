package com.example.inventory.domain.model

import androidx.room.Relation
import androidx.room.Embedded
import com.example.inventorymanager.domain.model.Provider
import java.util.Date

data class OrderWithProvider(
    @Embedded val order: Order,

    @Relation(
        parentColumn = "providerId",
        entityColumn = "id"
    )
    val provider: Provider
)
