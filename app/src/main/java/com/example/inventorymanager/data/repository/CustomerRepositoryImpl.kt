package com.example.inventorymanager.data.repository

import com.example.inventorymanager.data.dao.LocationDao
import com.example.inventorymanager.domain.model.Location
import com.example.inventorymanager.domain.repository.LocationRepository

class CustomerRepositoryImpl(
    private val locationDao: LocationDao
) : LocationRepository {

    override fun getLocationsFromRoom() = locationDao.getLocations()

    override suspend fun getLocationoFromRoom(id: Int) = locationDao.getById(id)

    override suspend fun addLocationToRoom(location: Location) = locationDao.insert(location)

    override suspend fun updateLocationInRoom(location: Location) = locationDao.update(location)

    override suspend fun deleteLocationFromRoom(id: Int) = locationDao.delete(id)

}