package ro.alexmamo.roomjetpackcompose.data.dao

import androidx.room.*
import com.example.inventory.domain.model.Order
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.relationshipdataclasses.OrderWithProducts


@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrder(order: Order): Long

    @Query("SELECT * FROM $ORDER_TABLE")
    suspend fun getAllOrders(): List<Order>

    @Transaction
    @Query("SELECT * FROM $ORDER_TABLE WHERE orderId = :orderId")
    suspend fun getOrderWithProducts(orderId: Long): OrderWithProducts

}