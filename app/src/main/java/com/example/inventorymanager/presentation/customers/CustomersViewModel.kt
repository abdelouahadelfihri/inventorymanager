package ro.alexmamo.roomjetpackcompose.presentation.customers

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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {

    val customers: Flow<List<Customer>> = repo.getCustomersFromRoom()

    var searchQuery by mutableStateOf("")
    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var customer by mutableStateOf(Customer(0, EMPTY_STRING, EMPTY_STRING))
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

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

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
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