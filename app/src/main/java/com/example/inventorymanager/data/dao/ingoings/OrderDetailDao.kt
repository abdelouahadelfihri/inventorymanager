package com.example.inventorymanager.data.dao.ingoings

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrderLine
import kotlinx.coroutines.flow.Flow

@Dao
interface OrderDetailDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insert(orderDetails: PurchaseOrderLine)

    @Update
    suspend fun update(orderDetails: PurchaseOrderLine)

    @Query("DELETE FROM order_details WHERE orderId = :orderId AND productId = :productId AND warehouseId = :warehouseId")
    suspend fun delete(orderId: Int, productId: Int, warehouseId: Int): Int

    @Query("SELECT * FROM ${Constants.Companion.ORDER_DETAILS_TABLE} WHERE orderId = :orderId AND productId = :productId AND warehouseId = :warehouseId LIMIT 1")
    suspend fun getByIds(orderId: Int, productId: Int, warehouseId: Int): PurchaseOrderLine?

    @Query("SELECT * FROM ${Constants.Companion.ORDER_DETAILS_TABLE}")
    fun getAll(): Flow<List<PurchaseOrderLine>>
}