package com.example.inventorymanager.data.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.data.dao.masterdata.LocationDao
import com.example.inventorymanager.domain.repository.masterdata.LocationRepository

class LocationRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {
    override fun getLocationsFromRoom() = locationDao.getLocations()

    override suspend fun getLocationFromRoom(id: Int) = locationDao.getLocation(id)

    override suspend fun addLocationToRoom(location: Location) = locationDao.addLocation(location)

    override suspend fun updateLocationInRoom(location: Location) = locationDao.updateLocation(location)

    override suspend fun deleteLocationFromRoom(id: Int) = locationDao.deleteLocation(id)

}