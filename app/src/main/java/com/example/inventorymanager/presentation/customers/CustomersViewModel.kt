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
import com.example.inventorymanager.domain.model.Delivery
import com.example.inventorymanager.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {

    private val _customers = MutableStateFlow<List<Customer>>(emptyList())
    val customers: StateFlow<List<Customer>> = _customers

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var customer by mutableStateOf(Customer(
        0, EMPTY_STRING, EMPTY_STRING,
        phone = TODO(),
        mobile = TODO(),
        fax = TODO(),
        address = TODO()
    ))
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getCustomer(id: Int) = viewModelScope.launch {
        customer = repo.getCustomerFromRoom(id)
    }

    init {
        observeCustomersFromRoom()
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

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeCustomersFromRoom() {
        viewModelScope.launch {
            repo.getCustomersFromRoom()
                .collect { list ->
                    _customers.value = list
                }
        }
    }

    val filteredCustomers: List<Customer>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _customers.value.filter { customer ->
                terms.any { term ->
                    customer.customerId.toString().contains(term) ||
                            customer.name.toString().lowercase().contains(term) ||
                            customer.address.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshCustomers() {
        // This is optional if Room is live. But you can re-collect:
        observeCustomersFromRoom()
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