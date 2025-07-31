package com.example.inventorymanager.presentation.masterdata.units

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.Unit
import com.example.inventorymanager.domain.repository.masterdata.UnitRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class UnitsViewModel @Inject constructor(
    private val repo: UnitRepository
) : ViewModel() {

    private val _units = MutableStateFlow<List<Unit>>(emptyList())
    val units: StateFlow<List<Unit>> = _units

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var unit by mutableStateOf(
        Unit (
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
        observeProvidersFromRoom()
    }

    fun addUnit(unit: Unit) = viewModelScope.launch {
        repo.addUnitToRoom(unit)
    }

    fun updateProvider(customer: Provider) = viewModelScope.launch {
        repo.updateProviderInRoom(customer)
    }

    fun deleteProvider(id: Int) = viewModelScope.launch {
        repo.deleteProviderFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeProvidersFromRoom() {
        viewModelScope.launch {
            repo.getProvidersFromRoom()
                .collect { list ->
                    _providers.value = list
                }
        }
    }

    val filteredProviders: List<Provider>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _providers.value.filter { provider ->
                terms.any { term ->
                    provider.providerId.toString().contains(term) ||
                            provider.name.toString().lowercase().contains(term) ||
                            provider.address.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshProviders() {
        // This is optional if Room is live. But you can re-collect:
        observeProvidersFromRoom()
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