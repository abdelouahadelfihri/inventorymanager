package com.example.inventorymanager.domain.repository.outgoings

import com.example.inventorymanager.domain.model.outgoings.DeliveryDetail
import kotlinx.coroutines.flow.Flow

typealias DeliveriesDetails = List<DeliveryDetail>

interface DeliveryDetailRepository {

    fun getDeliveriesDetailsFromRoom(): Flow<DeliveriesDetails>

    suspend fun getDeliveryDetailFromRoom(deliveryId: Int, productId: Int, warehouseId: Int): DeliveryDetail

    suspend fun addDeliveryDetailToRoom(deliveryDetails: DeliveryDetail)

    suspend fun updateDeliveryDetailInRoom(deliveryDetails: DeliveryDetail)

    suspend fun deleteDeliveryDetailFromRoom(deliveryId: Int, productId: Int, warehouseId: Int)

}