package com.example.inventorymanager.data.dao.outgoings

import androidx.room.*
import com.example.inventorymanager.core.Constants.Companion.SALE_RECEIPT_DETAIL_TABLE
import com.example.inventorymanager.domain.model.outgoings.DeliveryLine
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleReceiptDetailDao {

    @Query("SELECT * FROM $SALE_RECEIPT_DETAIL_TABLE WHERE saleReceiptId = :receiptId")
    fun getDetailsForReceipt(receiptId: Int): Flow<List<DeliveryLine>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDetail(detail: DeliveryLine)

    @Update
    suspend fun updateDetail(detail: DeliveryLine)

    @Delete
    suspend fun deleteDetail(detail: DeliveryLine)

    @Query("DELETE FROM $SALE_RECEIPT_DETAIL_TABLE WHERE saleReceiptId = :receiptId")
    suspend fun deleteAllDetailsForReceipt(receiptId: Int)
}