package com.example.inventorymanager.presentation.masterdata.warehouses

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import com.example.inventorymanager.domain.repository.masterdata.WarehouseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WarehousesViewModel @Inject constructor(
    private val repo: WarehouseRepository
) : ViewModel() {

    private val _warehouses = MutableStateFlow<List<Warehouse>>(emptyList())
    val warehouses: StateFlow<List<Warehouse>> = _warehouses

    val warehousesWithLocation = repo.getWarehousesWithLocation()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var warehouse by mutableStateOf(
        Warehouse(
            warehouseId = 0,
            name = "",
            isRefrigerated = 0,
            locationOwnerId = 0
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getWarehouse(id: Int) = viewModelScope.launch {
        warehouse = repo.getWarehouseFromRoom(id)
    }

    init {
        observeWarehousesFromRoom()
    }

    fun onLocationSelected(location: Location) {
        selectedLocation = location
    }

    var selectedLocation by mutableStateOf<Location?>(null)
        private set

    fun addWarehouse(warehouse: Warehouse) = viewModelScope.launch {
        repo.addWarehouseToRoom(warehouse)
    }

    fun updateWarehouse(warehouse: Warehouse) = viewModelScope.launch {
        repo.updateWarehouseInRoom(warehouse)
    }

    fun deleteWarehouse(id: Int) = viewModelScope.launch {
        repo.deleteWarehouseFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeWarehousesFromRoom() {
        viewModelScope.launch {
            repo.getWarehousesFromRoom()
                .collect { list ->
                    _warehouses.value = list
                }
        }
    }

    val filteredWarehouses: List<Warehouse>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
            return _warehouses.value.filter { warehouse ->
                terms.any { term ->
                    warehouse.warehouseId.toString().contains(term) ||
                            warehouse.name.toString().lowercase().contains(term) ||
                            warehouse.locationOwnerId.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshWarehouses() {
        // This is optional if Room is live. But you can re-collect:
        observeWarehousesFromRoom()
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