package com.example.inventorymanager.presentation.books

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

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {
    var customer by mutableStateOf(Customer(0, EMPTY_STRING, EMPTY_STRING))
        private set
    var openDialog by mutableStateOf(false)

    val customers = repo.getCustomersFromRoom()

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

    fun updateTitle(title: String) {
        customer = customer.copy(title = title)
    }

    fun updateAuthor(author: String) {
        customer = customer.copy(author = author)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }
}