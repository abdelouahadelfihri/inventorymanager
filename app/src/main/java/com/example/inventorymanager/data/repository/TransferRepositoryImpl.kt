package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Transfer
import com.example.inventorymanager.data.dao.TransferDao
import com.example.inventorymanager.domain.model.Provider
import com.example.inventorymanager.domain.repository.TransferRepository
import kotlinx.coroutines.flow.Flow

class TransferRepositoryImpl(
    private val transferDao: TransferDao
) : TransferRepository {
    override fun getTransfersFromRoom() = transferDao.getTransfers()

    override suspend fun getTransferFromRoom(id: Int) = transferDao.getTransfer(id)

    override suspend fun addTransferToRoom(transfer: Transfer) = transferDao.addTransfer(transfer)

    override suspend fun updateTransferInRoom(transfer: Transfer) = transferDao.updateTransfer(transfer)

    override suspend fun deleteTransferFromRoom(transfer: Transfer) = transferDao.deleteTransfer(transfer)

    override fun searchTransfers(query: String): Flow<List<Transfer>> {
        return transferDao.searchTransfers("%$query%")
    }
}