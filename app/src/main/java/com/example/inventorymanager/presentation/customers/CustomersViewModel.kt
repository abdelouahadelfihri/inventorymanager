import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.domain.repository.CustomerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CustomerViewModel(
    private val repository: CustomerRepository
) : ViewModel() {

    private val _customers = MutableStateFlow<List<Customer>>(emptyList())
    val customers: StateFlow<List<Customer>> = _customers

    var searchQuery by mutableStateOf("")
    var selectedFilter by mutableStateOf("All")
    val filters = listOf("All", "VIP", "Regular")

    init {
        loadCustomers()
    }

    fun loadCustomers() {
        viewModelScope.launch {
            _customers.value = repository.getCustomersFromRoom()
        }
    }

    fun onAddCustomer() {
        viewModelScope.launch {
            val newId = (_customers.value.maxOfOrNull { it.id } ?: 0) + 1
            val newCustomer = Customer(newId, "New Customer $newId", "Regular")
            repository.addCustomer(newCustomer)
            loadCustomers() // refresh list from DB/repo
        }
    }

    fun onClearCustomers() {
        viewModelScope.launch {
            _customers.value.forEach {
                repository.deleteCustomer(it)
            }
            loadCustomers()
        }
    }

    fun onRefreshCustomers() {
        loadCustomers()
    }

    fun onFilterSelected(filter: String) {
        selectedFilter = filter
    }

    fun onSearchChange(query: String) {
        searchQuery = query
    }

    val filteredCustomers: List<Customer>
        get() = _customers.value.filter {
            (selectedFilter == "All" || it.type == selectedFilter) &&
                    it.name.contains(searchQuery, ignoreCase = true)
        }
}