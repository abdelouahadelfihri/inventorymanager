package com.example.inventorymanager.presentation.masterdata.transfers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.domain.repository.LocationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TransfersViewModel @Inject constructor(
    private val repo: LocationRepository
) : ViewModel() {

    private val _locations = MutableStateFlow<List<Location>>(emptyList())
    val locations: StateFlow<List<Location>> = _locations

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var location by mutableStateOf(
        Location(
            locationId = 0,
            name = "", // or any default Date, like SimpleDateFormat().parse("1970-01-01")
            address = ""
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getLocation(id: Int) = viewModelScope.launch {
        location = repo.getLocationFromRoom(id)
    }

    init {
        observeLocationsFromRoom()
    }

    fun addLocation(location: Location) = viewModelScope.launch {
        repo.addLocationToRoom(location)
    }

    fun updateLocation(location: Location) = viewModelScope.launch {
        repo.updateLocationInRoom(location)
    }

    fun deleteLocation(id: Int) = viewModelScope.launch {
        repo.deleteLocationFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeLocationsFromRoom() {
        viewModelScope.launch {
            repo.getLocationsFromRoom()
                .collect { list ->
                    _locations.value = list
                }
        }
    }

    val filteredLocations: List<Location>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _locations.value.filter { location ->
                terms.any { term ->
                    location.locationId.toString().contains(term) ||
                            location.name.toString().lowercase().contains(term) ||
                            location.address.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshLocations() {
        // This is optional if Room is live. But you can re-collect:
        observeLocationsFromRoom()
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