package com.example.inventorymanager.domain.repository.masterdata

import com.example.inventorymanager.domain.model.masterdata.MeasurementUnit
import kotlinx.coroutines.flow.Flow

typealias MeasurementUnits = List<MeasurementUnit>

interface MeasurementUnitRepository {

    fun getMeasurementUnitsFromRoom(): Flow<MeasurementUnits>

    suspend fun getMeasurementUnitFromRoom(id: Int): MeasurementUnit

    suspend fun addMeasurementUnitToRoom(unit: MeasurementUnit)

    suspend fun updateMeasurementUnitInRoom(unit: MeasurementUnit)

    suspend fun deleteMeasurementUnitFromRoom(id: Int)

}