package com.example.inventorymanager.data.dao

import androidx.room.*
import com.example.inventorymanager.core.Constants.Companion.ORDER_DETAILS_TABLE
import com.example.inventorymanager.domain.model.Order
import com.example.inventorymanager.domain.model.OrderDetails


import androidx.room.*

@Dao
interface OrderDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderDetails: OrderDetails)

    @Update
    suspend fun update(orderDetails: OrderDetails)

    @Delete
    suspend fun delete(orderDetails: OrderDetails)

    @Query("SELECT * FROM order_details WHERE orderId = :orderId")
    suspend fun getByOrderId(orderId: Int): List<OrderDetails>

    @Query("SELECT * FROM order_details WHERE productId = :productId")
    suspend fun getByProductId(productId: Int): List<OrderDetails>

    @Query("SELECT * FROM order_details WHERE warehouseId = :warehouseId")
    suspend fun getByWarehouseId(warehouseId: Int): List<OrderDetails>

    @Query("SELECT * FROM order_details WHERE orderId = :orderId AND productId = :productId AND warehouseId = :warehouseId")
    suspend fun getByIds(orderId: Int, productId: Int, warehouseId: Int): OrderDetails?
}
