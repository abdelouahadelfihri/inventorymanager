package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Update
import com.example.inventorymanager.core.Constants.Companion.INVENTORY_TABLE
import com.example.inventorymanager.domain.model.Location
import com.example.inventorymanager.core.Constants.Companion.LOCATION_TABLE
import com.example.inventorymanager.domain.model.Inventory
import com.example.inventorymanager.domain.repository.Locations
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * FROM $LOCATION_TABLE ORDER BY locationId ASC")
    fun getLocations(): Flow<Locations>

    @Query("SELECT * FROM $LOCATION_TABLE WHERE locationId = :id")
    suspend fun getLocation(id: Int): Location

    @Insert(onConflict = IGNORE)
    suspend fun addLocation(location: Location)

    @Update
    suspend fun updateLocation(location: Location)

    @Delete
    suspend fun deleteLocation(id: Int)

}