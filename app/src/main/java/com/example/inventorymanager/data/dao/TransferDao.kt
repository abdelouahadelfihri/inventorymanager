package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.domain.model.Transfer
import com.example.inventorymanager.core.Constants.Companion.TRANSFER_TABLE
import com.example.inventorymanager.domain.repository.Transfers
import kotlinx.coroutines.flow.Flow

@Dao
interface TransferDao {

    @Query("SELECT * FROM $TRANSFER_TABLE ORDER BY transferId ASC")
    fun getTransfers(): Flow<Transfers>

    @Query("SELECT * FROM $TRANSFER_TABLE WHERE transferId = :id")
    suspend fun getTransfer(id: Int): Transfer

    @Insert(onConflict = IGNORE)
    suspend fun addTransfer(order: Transfer)

    @Update
    suspend fun updateTransfer(order: Transfer)

    @Delete
    suspend fun deleteTransfer(id: Int)

}