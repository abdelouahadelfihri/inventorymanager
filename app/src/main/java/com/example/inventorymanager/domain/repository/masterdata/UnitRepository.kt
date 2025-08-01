package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.MeasurementUnit
import kotlinx.coroutines.flow.Flow

typealias Units = List<MeasurementUnit>

interface UnitRepository {

    fun getUnitsFromRoom(): Flow<Units>

    suspend fun getUnitFromRoom(id: Int): MeasurementUnit

    suspend fun addUnitToRoom(unit: MeasurementUnit)

    suspend fun updateUnitInRoom(unit: MeasurementUnit)

    suspend fun deleteUnitFromRoom(id: Int)

}