package com.example.inventorymanager.presentation.masterdata.units

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.MeasurementUnit
import com.example.inventorymanager.domain.repository.masterdata.UnitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UnitsViewModel @Inject constructor(
    private val repo: UnitRepository
) : ViewModel() {

    private val _units = MutableStateFlow<List<MeasurementUnit>>(emptyList())
    val units: StateFlow<List<MeasurementUnit>> = _units

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var unit by mutableStateOf(
        MeasurementUnit (
            unitId = 0,
            name = "",
            abbreviation = ""
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getUnitFromRoom(id: Int) = viewModelScope.launch {
        unit = repo.getUnitFromRoom(id)
    }

    init {
        observeUnitsFromRoom()
    }

    fun addUnit(unit: MeasurementUnit) {
        viewModelScope.launch {
            repo.addUnitToRoom(unit)
        }
    }

    fun updateUnit(unit: MeasurementUnit) = viewModelScope.launch {
        repo.updateUnitInRoom(unit)
    }

    fun deleteUnit(id: Int) = viewModelScope.launch {
        repo.deleteUnitFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeUnitsFromRoom() {
        viewModelScope.launch {
            repo.getUnitsFromRoom()
                .collect { list ->
                    _units.value = list
                }
        }
    }

    val filteredUnits: List<MeasurementUnit>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _units.value.filter { unit ->
                terms.any { term ->
                    unit.unitId.toString().contains(term) ||
                    unit.name.lowercase().contains(term) ||
                            unit.abbreviation.lowercase().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshUnits() {
        // This is optional if Room is live. But you can re-collect:
        observeUnitsFromRoom()
    }

    fun onClearSearch() {
        searchQuery = ""
    }
    fun onFilterSelected(filter: String) {
        selectedFilter = filter
    }

    fun onSearchChange(query: String) {
        searchQuery = query
    }
}