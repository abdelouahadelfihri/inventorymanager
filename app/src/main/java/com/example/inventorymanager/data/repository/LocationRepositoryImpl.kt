package com.example.inventorymanager.data.repository

import com.example.inventorymanager.domain.model.Location
import com.example.inventorymanager.data.dao.LocationDao
import com.example.inventorymanager.domain.repository.LocationRepository

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {
    override fun getLocationsFromRoom() = locationDao.getLocations()

    override suspend fun getLocationFromRoom(id: Int) = locationDao.getLocation(id)

    override suspend fun addLocationToRoom(warehouse: Location) = locationDao.addLocation(warehouse)

    override suspend fun updateLocationInRoom(warehouse: Location) = locationDao.updateLocation(warehouse)

    override suspend fun deleteLocationFromRoom(warehouse: Location) = locationDao.deleteLocation(warehouse)
}