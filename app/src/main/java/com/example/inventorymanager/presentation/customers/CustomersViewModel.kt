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
import javax.inject.Inject

@HiltViewModel
class CustomersViewModel @Inject constructor(
    private val repo: CustomerRepository
) : ViewModel() {
    var customer by mutableStateOf(Customer(0, EMPTY_STRING, EMPTY_STRING))
        private set
    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    val customers = repo.getCustomersFromRoom()

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

    fun onRefreshCustomers() {
        loadCustomers()
    }
}