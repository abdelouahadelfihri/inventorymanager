package com.example.inventory.data.dao

import androidx.room.*
import com.example.inventory.domain.model.OrderDetails



@Dao
interface OrderDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderDetails(orderDetails: OrderDetails)

    @Query("SELECT * FROM order_details WHERE orderId = :orderId")
    suspend fun getOrderDetailsForOrder(orderId: Long): List<OrderDetails>

    @Query("SELECT * FROM order_details WHERE productId = :productId")
    suspend fun getOrderDetailsForProduct(productId: Long): List<OrderDetails>

}