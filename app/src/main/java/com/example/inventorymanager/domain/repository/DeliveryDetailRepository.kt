package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.outgoings.DeliveryDetails
import kotlinx.coroutines.flow.Flow

typealias DeliveriesDetails = List<DeliveryDetails>

interface DeliveryDetailRepository {

    fun getDeliveriesDetailsFromRoom(): Flow<DeliveriesDetails>

    suspend fun getDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int): DeliveryDetails

    suspend fun addDeliveryDetailsToRoom(deliveryDetails: DeliveryDetails)

    suspend fun updateDeliveryDetailsInRoom(deliveryDetails: DeliveryDetails)

    suspend fun deleteDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int)

}