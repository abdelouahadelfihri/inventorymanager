package com.example.inventorymanager.domain.repository.outgoings

import com.example.inventorymanager.domain.model.outgoings.SalesOrderLine
import kotlinx.coroutines.flow.Flow

typealias DeliveriesDetails = List<SalesOrderLine>

interface DeliveryDetailRepository {

    fun getDeliveriesDetailsFromRoom(): Flow<DeliveriesDetails>

    suspend fun getDeliveryDetailFromRoom(deliveryId: Int, productId: Int, warehouseId: Int): SalesOrderLine

    suspend fun addDeliveryDetailToRoom(deliveryDetails: SalesOrderLine)

    suspend fun updateDeliveryDetailInRoom(deliveryDetails: SalesOrderLine)

    suspend fun deleteDeliveryDetailFromRoom(deliveryId: Int, productId: Int, warehouseId: Int)

}