package com.example.inventorymanager.presentation.providers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.Provider
import com.example.inventorymanager.domain.repository.ProviderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProvidersViewModel @Inject constructor(
    private val repo: ProviderRepository
) : ViewModel() {

    private val _providers = MutableStateFlow<List<Provider>>(emptyList())
    val providers: StateFlow<List<Provider>> = _providers

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var provider = mutableStateOf(
        Provider(
            0,
            name = "",
            address = ""
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getProvider(id: Int) = viewModelScope.launch {
        provider.value = repo.getProviderFromRoom(id)
    }

    init {
        observeProvidersFromRoom()
    }

    fun addProvider(customer: Provider) = viewModelScope.launch {
        repo.addProviderToRoom(customer)
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