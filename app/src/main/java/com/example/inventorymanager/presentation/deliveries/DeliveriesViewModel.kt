package com.example.inventorymanager.presentation.deliveries

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.Delivery
import com.example.inventorymanager.domain.repository.DeliveryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class DeliveriesViewModel @Inject constructor(
    private val repo: DeliveryRepository
) : ViewModel() {

    private val _deliveries = MutableStateFlow<List<Delivery>>(emptyList())
    val deliveries: StateFlow<List<Delivery>> = _deliveries

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var delivery by mutableStateOf(
        Delivery(
            deliveryId = 0,
            saleDate = Date(), // or any default Date, like SimpleDateFormat().parse("1970-01-01")
            customerId = 0
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getDelivery(id: Int) = viewModelScope.launch {
        delivery = repo.getDeliveryFromRoom(id)
    }

    init {
        observeDeliveriesFromRoom()
    }

    fun addDelivery(customer: Delivery) = viewModelScope.launch {
        repo.addDeliveryToRoom(customer)
    }

    fun updateDelivery(customer: Delivery) = viewModelScope.launch {
        repo.updateDeliveryInRoom(customer)
    }

    fun deleteDelivery(id: Int) = viewModelScope.launch {
        repo.deleteDeliveryFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeDeliveriesFromRoom() {
        viewModelScope.launch {
            repo.getDeliveriesFromRoom()
                .collect { list ->
                    _deliveries.value = list
                }
        }
    }

    val filteredDeliveries: List<Delivery>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _deliveries.value.filter { delivery ->
                terms.any { term ->
                    delivery.deliveryId.toString().contains(term) ||
                            delivery.saleDate.toString().lowercase().contains(term) ||
                            delivery.customerId.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshDeliveries() {
        // This is optional if Room is live. But you can re-collect:
        observeDeliveriesFromRoom()
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