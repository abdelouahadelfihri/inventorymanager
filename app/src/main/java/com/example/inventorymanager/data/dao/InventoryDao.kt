package ro.alexmamo.roomjetpackcompose.data.dao

import androidx.room.*
import com.example.inventory.domain.model.Inventory

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(inventory: Inventory)

    @Update
    suspend fun update(inventory: Inventory)

    @Delete
    suspend fun delete(inventory: Inventory)

    @Query("SELECT * FROM inventory")
    suspend fun getAll(): List<Inventory>

    @Query("SELECT * FROM inventory WHERE inventoryId = :id")
    suspend fun getById(id: Int): Inventory?
}
