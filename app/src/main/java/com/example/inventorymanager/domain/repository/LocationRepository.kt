package com.example.inventorymanager.domain.repository

import com.example.inventory.domain.model.Delivery
import com.example.inventorymanager.domain.model.Location
import kotlinx.coroutines.flow.Flow


typealias Locations = List<Location>

interface LocationRepository {

    fun getLocationsFromRoom(): Flow<Locations>

    suspend fun getLocationFromRoom(id: Int): Location

    suspend fun addLocationToRoom(location: Location)

    suspend fun updateLocationInRoom(location: Location)

    suspend fun deleteLocationFromRoom(location: Location)

}