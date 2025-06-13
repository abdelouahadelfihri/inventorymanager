package com.example.inventorymanager.presentation.customers

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.core.Constants.Companion.EMPTY_STRING
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import kotlin.collections.plus

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {
    var customer by mutableStateOf(Customer(0, EMPTY_STRING, EMPTY_STRING))
        private set
    var openDialog by mutableStateOf(false)

    val customers = repo.getCustomersFromRoom()

    var searchQuery by mutableStateOf("")
    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "VIP", "Regular")

    // 🔹 Add StateFlow for search results
    private val _searchResults = MutableStateFlow<List<Customer>>(emptyList())
    val searchResults: StateFlow<List<Customer>> = _searchResults

    fun getCustomer(id: Int) = viewModelScope.launch {
        customer = repo.getCustomerFromRoom(id)
    }

    fun addCustomer(customer: Customer) = viewModelScope.launch {
        repo.addCustomerToRoom(customer)
    }

    fun updateCustomer(customer: Customer) = viewModelScope.launch {
        repo.updateCustomerInRoom(customer)
    }

    fun deleteCustomer(id: Int) = viewModelScope.launch {
        repo.deleteCustomerFromRoom(id)
    }

    // 🔹 Search function
    fun searchCustomers(query: String) {
        viewModelScope.launch {
            repo.searchCustomers(query).collect { customers ->
                _searchResults.value = customers
            }
        }
    }

    var filteredCustomers by mutableStateOf(allCustomers)
        private set

    fun onSearchChange(query: String) {
        searchQuery = query
        applyFilter()
    }

    fun onFilterSelected(filter: String) {
        selectedFilter = filter
        applyFilter()
    }

    fun onAddCustomer() {
        val newId = allCustomers.size + 1
        val newCustomer = Customer(newId, "New Customer $newId", "Regular")
        allCustomers = allCustomers + newCustomer
        applyFilter()
    }

    fun onClearCustomers() {
        allCustomers = emptyList()
        applyFilter()
    }

    fun onRefreshCustomers() {
        allCustomers = listOf(
            Customer(1, "Alice", "VIP"),
            Customer(2, "Bob", "Regular"),
            Customer(3, "Charlie", "VIP"),
            Customer(4, "Diana", "Regular")
        )
        applyFilter()
    }

    private fun applyFilter() {
        filteredCustomers = allCustomers.filter {
            (selectedFilter == "All" || it.type == selectedFilter) &&
                    it.name.contains(searchQuery, ignoreCase = true)
        }
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}