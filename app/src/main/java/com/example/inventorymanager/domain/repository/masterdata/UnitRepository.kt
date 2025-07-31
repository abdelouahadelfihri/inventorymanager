package com.example.inventorymanager.domain.repository.masterdata

import kotlinx.coroutines.flow.Flow

typealias Units = List<Unit>

interface UnitRepository {

    fun getUnitsFromRoom(): Flow<Units>

    suspend fun getUnitFromRoom(id: Int): Unit

    suspend fun addUnitToRoom(unit: Unit)

    suspend fun updateUnitInRoom(unit: Unit)

    suspend fun deleteUnitFromRoom(id: Int)

}