package com.example.inventorymanager.domain.repository

import com.example.inventory.domain.model.DeliveryDetails
import com.example.inventorymanager.domain.model.Delivery
import kotlinx.coroutines.flow.Flow

typealias DeliveriesDetails = List<DeliveryDetails>

interface DeliveryDetailsRepository {

    fun getDeliveriesDetailsFromRoom(): Flow<DeliveriesDetails>

    suspend fun getDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int): DeliveryDetails

    suspend fun addDeliveryDetailsToRoom(deliveryDetails: DeliveryDetails)

    suspend fun updateDeliveryDetailsInRoom(deliveryDetails: DeliveryDetails)

    suspend fun deleteDeliveryDetailsFromRoom(deliveryId: Int, productId: Int, warehouseId: Int)

    fun searchDeliveriesDetails(query: String): Flow<List<DeliveryDetails>>
}