package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Location
import kotlinx.coroutines.flow.Flow


typealias Locations = List<Location>

interface LocationRepository {

    fun getLocationsFromRoom(): Flow<Locations>

    suspend fun getLocationFromRoom(id: Int): Location

    suspend fun addLocationToRoom(location: Location)

    suspend fun updateLocationInRoom(location: Location)

    suspend fun deleteLocationFromRoom(id: Int)

}