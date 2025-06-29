package com.example.inventorymanager.data.dao.ingoings

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_RECEIPT_TABLE
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.repository.Orders
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseReceiptDao {

    @Query("SELECT * FROM ${PURCHASE_RECEIPT_TABLE} ORDER BY orderId ASC")
    fun getPurchaseReceipts(): Flow<Orders>

    @Query("SELECT * FROM ${PURCHASE_RECEIPT_TABLE} WHERE orderId = :id")
    suspend fun getPurchaseReceipt(id: Int): Order

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addPurchaseReceipt(order: Order)

    @Update
    suspend fun updatePurchaseReceipt(order: Order)

    @Delete
    suspend fun deletePurchaseReceipt(id: Int)

}