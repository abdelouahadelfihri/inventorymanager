package com.example.inventorymanager.presentation.masterdata.inventories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.Transfer
import com.example.inventorymanager.domain.repository.masterdata.TransferRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Date
import javax.inject.Inject
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@HiltViewModel
class TransfersViewModel @Inject constructor(
    private val repo: TransferRepository
) : ViewModel() {

    private val _transfers = MutableStateFlow<List<Transfer>>(emptyList())
    val transfers: StateFlow<List<Transfer>> = _transfers

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var transfer by mutableStateOf(
        Transfer(
            transferId = 0,
            date = Date(),
            quantity = 0,
            originWarehouseId = 0,
            destinationWarehouseId = 0,
            productId = 0
        )
    )
        private set

    var selectedOriginWarehouse by mutableStateOf<Warehouse?>(null)
        private set

    var selectedDestinationWarehouse by mutableStateOf<Warehouse?>(null)
        private set

    var selectedProduct by mutableStateOf<Product?>(null)
        private set

    fun selectOriginWarehouse(warehouse: Warehouse) {
        selectedOriginWarehouse = warehouse
    }

    fun selectDestinationWarehouse(warehouse: Warehouse) {
        selectedDestinationWarehouse = warehouse
    }

    fun selectProduct(product: Product) {
        selectedProduct = product
    }

    fun clearTransferForm() {
        transfer = Transfer(
            transferId = 0,
            date = Date(),
            quantity = 0,
            originWarehouseId = 0,
            destinationWarehouseId = 0,
            productId = 0
        )
        selectedOriginWarehouse = null
        selectedDestinationWarehouse = null
        selectedProduct = null
    }

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getTransfer(id: Int) = viewModelScope.launch {
        transfer = repo.getTransferFromRoom(id)
    }

    init {
        observeTransfersFromRoom()
    }

    fun addTransfer(location: Transfer) = viewModelScope.launch {
        repo.addTransferToRoom(location)
    }

    fun updateTransfer(location: Transfer) = viewModelScope.launch {
        repo.updateTransferInRoom(location)
    }

    fun deleteTransfer(id: Int) = viewModelScope.launch {
        repo.deleteTransferFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeTransfersFromRoom() {
        viewModelScope.launch {
            repo.getTransfersFromRoom()
                .collect { list ->
                    _transfers.value = list
                }
        }
    }

    val filteredTransfers: List<Transfer>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _transfers.value.filter { transfer ->
                terms.any { term ->
                    transfer.transferId.toString().contains(term) ||
                            transfer.date.toString().contains(term) ||
                            transfer.quantity.toString().contains(term) ||
                            transfer.originWarehouseId.toString().contains(term) ||
                            transfer.destinationWarehouseId.toString().contains(term) ||
                            transfer.productId.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshTransfers() {
        // This is optional if Room is live. But you can re-collect:
        observeTransfersFromRoom()
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