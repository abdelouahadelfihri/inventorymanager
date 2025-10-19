package com.example.inventorymanager.data.dao.ingoings

import androidx.room.*
import com.example.inventorymanager.core.Constants.Companion.PURCHASE_RECEIPT_DETAIL_TABLE
import com.example.inventorymanager.domain.model.ingoings.PurchaseReceiptLine
import kotlinx.coroutines.flow.Flow

@Dao
interface PurchaseReceiptDetailDao {

    @Query("SELECT * FROM $PURCHASE_RECEIPT_DETAIL_TABLE WHERE purchaseReceiptId = :receiptId")
    fun getDetailsForReceipt(receiptId: Int): Flow<List<PurchaseReceiptLine>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDetail(detail: PurchaseReceiptLine)

    @Update
    suspend fun updateDetail(detail: PurchaseReceiptLine)

    @Delete
    suspend fun deleteDetail(detail: PurchaseReceiptLine)

    @Query("DELETE FROM $PURCHASE_RECEIPT_DETAIL_TABLE WHERE purchaseReceiptId = :receiptId")
    suspend fun deleteAllDetailsForReceipt(receiptId: Int)
}