package com.example.inventorymanager.presentation.masterdata.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventorymanager.domain.model.outgoings.Customer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.ingoings.Order
import com.example.inventorymanager.domain.model.ingoings.Provider
import com.example.inventorymanager.domain.model.masterdata.Category
import com.example.inventorymanager.domain.repository.masterdata.ProductRepository
import com.example.inventorymanager.domain.model.masterdata.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repo: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _units = MutableStateFlow<List<Unit>>(emptyList())
    val units: StateFlow<List<Unit>> = _units

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    // You would typically populate it from a repository
    init {
        viewModelScope.launch {
            repo.getProductsFromRoom().collect { orderList ->
                _products.value = orderList
            }
        }
    }

    fun onProviderSelected(provider: Provider) {
        selectedProvider = provider
    }

    var selectedProvider by mutableStateOf<Provider?>(null)
        private set

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var order by mutableStateOf(
        Order(
            orderId = 0,
            providerId = 0,
            orderDate = Date()
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getOrder(id: Int) = viewModelScope.launch {
        order = repo.getOrderFromRoom(id)
    }

    init {
        observeOrdersFromRoom()
    }

    fun addOrder(customer: Order) = viewModelScope.launch {
        repo.addOrderToRoom(customer)
    }

    fun updateOrder(customer: Order) = viewModelScope.launch {
        repo.updateOrderInRoom(customer)
    }

    fun deleteOrder(id: Int) = viewModelScope.launch {
        repo.deleteOrderFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeOrdersFromRoom() {
        viewModelScope.launch {
            repo.getOrdersFromRoom()
                .collect { list ->
                    _orders.value = list
                }
        }
    }

    val filteredOrders: List<Order>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _orders.value.filter { order ->
                terms.any { term ->
                    order.orderId.toString().contains(term) ||
                            order.orderDate.toString().contains(term) ||
                            order.providerId.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshOrders() {
        // This is optional if Room is live. But you can re-collect:
        observeOrdersFromRoom()
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