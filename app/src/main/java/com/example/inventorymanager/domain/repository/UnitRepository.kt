package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.domain.model.ingoings.Provider
import kotlinx.coroutines.flow.Flow


typealias Units = List<Unit>

interface ProductUnitRepository {

    fun getUnitsFromRoom(): Flow<Units>

    suspend fun getUnitFromRoom(id: Int): Unit

    suspend fun addUnitToRoom(unit: Unit)

    suspend fun updateProviderInRoom(provider: Provider)

    suspend fun deleteProviderFromRoom(id: Int)

}