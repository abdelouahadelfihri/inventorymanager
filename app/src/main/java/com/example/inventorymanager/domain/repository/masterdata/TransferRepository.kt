package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Transfer
import kotlinx.coroutines.flow.Flow


typealias Transfers = List<Transfer>

interface TransferRepository {

    fun getTransfersFromRoom(): Flow<Transfers>

    suspend fun getTransferFromRoom(id: Int): Transfer

    suspend fun addTransferToRoom(transfer: Transfer)

    suspend fun updateTransferInRoom(transfer: Transfer)

    suspend fun deleteTransferFromRoom(id: Int)

}