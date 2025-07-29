package com.example.inventorymanager.data.dao.masterdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.masterdata.Transfer
import com.example.inventorymanager.domain.repository.masterdata.Transfers
import kotlinx.coroutines.flow.Flow

@Dao
interface TransferDao {

    @Query("SELECT * FROM ${Constants.Companion.TRANSFER_TABLE} ORDER BY transferId ASC")
    fun getTransfers(): Flow<Transfers>

    @Query("SELECT * FROM ${Constants.Companion.TRANSFER_TABLE} WHERE transferId = :id")
    suspend fun getTransfer(id: Int): Transfer

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addTransfer(order: Transfer)

    @Update
    suspend fun updateTransfer(order: Transfer)

    @Delete
    suspend fun deleteTransfer(id: Int)

}