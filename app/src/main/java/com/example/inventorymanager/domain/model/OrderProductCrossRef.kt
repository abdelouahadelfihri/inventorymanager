package com.example.inventory.domain.model

import androidx.room.Entity

@Entity(primaryKeys = ["orderId", "productId"])
data class OrderProductCrossRef(
    val orderId: Long,
    val productId: Long,
    val quantity: Int
)