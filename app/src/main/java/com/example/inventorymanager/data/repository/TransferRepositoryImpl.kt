package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Transfer
import com.example.inventorymanager.data.dao.TransferDao
import com.example.inventorymanager.domain.repository.TransferRepository

class TransferRepositoryImpl(
    private val orderDao: TransferDao
) : TransferRepository {
    override fun getTransfersFromRoom() = orderDao.getTransfers()

    override suspend fun getTransferFromRoom(id: Int) = orderDao.getTransfer(id)

    override suspend fun addTransferToRoom(order: Transfer) = orderDao.addTransfer(order)

    override suspend fun updateTransferInRoom(order: Transfer) = orderDao.updateTransfer(order)

    override suspend fun deleteTransferFromRoom(order: Transfer) = orderDao.deleteTransfer(order)
}