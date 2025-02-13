package com.example.inventorymanager.domain.repository

import com.example.inventory.domain.model.Transfer
import kotlinx.coroutines.flow.Flow


typealias Transfers = List<Transfer>

interface TransferRepository {

    fun getTransfersFromRoom(): Flow<Locations>

    suspend fun getTransferFromRoom(id: Int): Transfer

    suspend fun addTransferToRoom(transfer: Transfer)

    suspend fun updateTransferInRoom(transfer: Transfer)

    suspend fun deleteTransferFromRoom(transfer: Transfer)

}