package com.example.inventorymanager.data.dao.outgoings

import androidx.room.*
import com.example.inventorymanager.core.Constants.Companion.SALE_RECEIPT_DETAIL_TABLE
import com.example.inventorymanager.domain.model.outgoings.SaleReceiptDetail
import kotlinx.coroutines.flow.Flow

@Dao
interface SaleReceiptDetailDao {

    @Query("SELECT * FROM $SALE_RECEIPT_DETAIL_TABLE WHERE saleReceiptId = :receiptId")
    fun getDetailsForReceipt(receiptId: Int): Flow<List<SaleReceiptDetail>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDetail(detail: SaleReceiptDetail)

    @Update
    suspend fun updateDetail(detail: SaleReceiptDetail)

    @Delete
    suspend fun deleteDetail(detail: SaleReceiptDetail)

    @Query("DELETE FROM $SALE_RECEIPT_DETAIL_TABLE WHERE saleReceiptId = :receiptId")
    suspend fun deleteAllDetailsForReceipt(receiptId: Int)
}