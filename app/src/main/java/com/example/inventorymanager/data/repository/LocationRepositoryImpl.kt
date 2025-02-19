package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Location
import com.example.inventorymanager.data.dao.LocationDao
import com.example.inventorymanager.domain.model.Inventory
import com.example.inventorymanager.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {
    override fun getLocationsFromRoom() = locationDao.getLocations()

    override suspend fun getLocationFromRoom(id: Int) = locationDao.getLocation(id)

    override suspend fun addLocationToRoom(location: Location) = locationDao.addLocation(location)

    override suspend fun updateLocationInRoom(location: Location) = locationDao.updateLocation(location)

    override suspend fun deleteLocationFromRoom(location: Location) = locationDao.deleteLocation(location)

    override fun searchLocations(query: String): Flow<List<Location>> {
        return locationDao.searchLocations("%$query%")
    }
}