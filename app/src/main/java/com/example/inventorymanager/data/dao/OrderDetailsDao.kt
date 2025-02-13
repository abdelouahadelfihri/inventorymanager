package ro.alexmamo.roomjetpackcompose.data.dao

import androidx.room.*
import com.example.inventory.domain.model.Order
import com.example.inventory.domain.model.OrderDetails
import com.example.inventorymanager.core.Constants.Companion.ORDER_TABLE
import com.example.inventorymanager.domain.relationshipdataclasses.OrderWithProducts


@Dao
interface OrderDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderDetails(orderDetails: OrderDetails)

    @Query("SELECT * FROM order_details WHERE orderId = :orderId")
    suspend fun getOrderDetailsForOrder(orderId: Long): List<OrderDetails>

    @Query("SELECT * FROM order_details WHERE productId = :productId")
    suspend fun getOrderDetailsForProduct(productId: Long): List<OrderDetails>

}