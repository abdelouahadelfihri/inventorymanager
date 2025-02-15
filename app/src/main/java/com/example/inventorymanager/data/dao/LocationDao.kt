package com.example.inventorymanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.inventorymanager.core.Constants.Companion.LOCATION_TABLE
import com.example.inventorymanager.domain.model.Location

@Dao
interface LocationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(location: Location)

    @Update
    suspend fun update(location: Location)

    @Delete
    suspend fun delete(id: Int)

    @Query("SELECT * FROM $LOCATION_TABLE")
    suspend fun getLocations(): List<Location>

    @Query("SELECT * FROM $LOCATION_TABLE WHERE locationId = :id")
    suspend fun getById(id: Int): Location?
}