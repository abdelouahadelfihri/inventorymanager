package ro.alexmamo.roomjetpackcompose.data.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.Companion.IGNORE
import kotlinx.coroutines.flow.Flow
import com.example.inventorymanager.core.Constants.Companion.BOOK_TABLE
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.relationshipdataclasses.ProductWithOrders
import com.example.inventorymanager.domain.repository.Books

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Product): Long

    @Query("SELECT * FROM product")
    suspend fun getAllProducts(): List<Product>

    @Transaction
    @Query("SELECT * FROM product WHERE productId = :productId")
    suspend fun getProductWithOrders(productId: Long): ProductWithOrders

}