package com.example.inventorymanager.data.dao.masterdata

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.inventorymanager.core.Constants
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.domain.repository.Locations
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Query("SELECT * FROM ${Constants.Companion.LOCATION_TABLE} ORDER BY locationId ASC")
    fun getLocations(): Flow<Locations>

    @Query("SELECT * FROM ${Constants.Companion.LOCATION_TABLE} WHERE locationId = :id")
    suspend fun getLocation(id: Int): Location

    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun addLocation(location: Location)

    @Update
    suspend fun updateLocation(location: Location)

    @Delete
    suspend fun deleteLocation(id: Int)

}