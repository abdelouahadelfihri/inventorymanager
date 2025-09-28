package com.example.inventorymanager.data.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Transfer
import com.example.inventorymanager.data.dao.masterdata.TransferDao
import com.example.inventorymanager.domain.repository.masterdata.TransferRepository
import kotlinx.coroutines.flow.Flow

class TransferRepositoryImpl(
    private val transferDao: TransferDao
) : TransferRepository {
    override fun getTransfersFromRoom() = transferDao.getTransfers()

    override suspend fun getTransferFromRoom(id: Int) = transferDao.getTransfer(id)

    override suspend fun addTransferToRoom(transfer: Transfer) = transferDao.addTransfer(transfer)

    override suspend fun updateTransferInRoom(transfer: Transfer) = transferDao.updateTransfer(transfer)

    override suspend fun deleteTransferFromRoom(id: Int) = transferDao.deleteTransfer(id)

}