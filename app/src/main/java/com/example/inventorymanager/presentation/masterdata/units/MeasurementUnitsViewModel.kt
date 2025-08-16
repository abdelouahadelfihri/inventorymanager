package com.example.inventorymanager.presentation.masterdata.units

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.MeasurementUnit
import com.example.inventorymanager.domain.repository.masterdata.MeasurementUnitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MeasurementUnitsViewModel @Inject constructor(
    private val repo: MeasurementUnitRepository
) : ViewModel() {

    private val _measurementUnits = MutableStateFlow<List<MeasurementUnit>>(emptyList())
    val measurementUnits: StateFlow<List<MeasurementUnit>> = _measurementUnits

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

    fun getMeasurementUnit(id: Int) = viewModelScope.launch {
        unit = repo.getMeasurementUnitFromRoom(id)
    }

    init {
        observeUnitsFromRoom()
    }

    fun addMeasurementUnit(unit: MeasurementUnit) = viewModelScope.launch {
        repo.addMeasurementUnitToRoom(unit)
    }

    fun updateMeasurementUnit(unit: MeasurementUnit) = viewModelScope.launch {
        repo.updateMeasurementUnitInRoom(unit)
    }

    fun deleteMeasurementUnit(id: Int) = viewModelScope.launch {
        repo.deleteMeasurementUnitFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeUnitsFromRoom() {
        viewModelScope.launch {
            repo.getMeasurementUnitsFromRoom()
                .collect { list ->
                    _measurementUnits.value = list
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

            return _measurementUnits.value.filter { unit ->
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