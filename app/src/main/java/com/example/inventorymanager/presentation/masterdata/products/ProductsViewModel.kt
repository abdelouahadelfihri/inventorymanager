package com.example.inventorymanager.presentation.masterdata.products

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.MeasurementUnit
import com.example.inventorymanager.domain.model.masterdata.Category
import com.example.inventorymanager.domain.repository.masterdata.ProductRepository
import com.example.inventorymanager.domain.model.masterdata.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val repo: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _units = MutableStateFlow<List<MeasurementUnit>>(emptyList())
    val units: StateFlow<List<MeasurementUnit>> = _units

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

    fun onUnitSelected(unit: MeasurementUnit) {
        selectedUnit = unit
    }

    var selectedUnit by mutableStateOf<MeasurementUnit?>(null)
        private set

    fun onCategorySelected(category: Category) {
        selectedCategory = category
    }

    var selectedCategory by mutableStateOf<Category?>(null)
        private set

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var product by mutableStateOf(
        Product(
            productId = 0,
            name = "",
            code = "",
            barCode = "",
            category = 0,
            unit = 0,
            reorderLevel = 0,
            isActive = true
        )
    )

        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getProduct(id: Int) = viewModelScope.launch {
        product = repo.getProductFromRoom(id)
    }

    init {
        observeProductsFromRoom()
    }

    fun addProduct(customer: Product) = viewModelScope.launch {
        repo.addProductToRoom(customer)
    }

    fun updateProduct(customer: Product) = viewModelScope.launch {
        repo.updateProductInRoom(customer)
    }

    fun deleteProduct(id: Int) = viewModelScope.launch {
        repo.deleteProductFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeProductsFromRoom() {
        viewModelScope.launch {
            repo.getProductsFromRoom()
                .collect { list ->
                    _products.value = list
                }
        }
    }

    val filteredProducts: List<Product>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _products.value.filter { product ->
                terms.any { term ->
                    product.productId.toString().contains(term) ||
                            product.name.contains(term) ||
                            product.code.contains(term) ||
                            product.barCode.contains(term) ||
                            product.category.toString().contains(term) ||
                            product.unit.toString().contains(term) ||
                            product.reorderLevel.toString().contains(term) ||
                            product.isActive.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshProducts() {
        // This is optional if Room is live. But you can re-collect:
        observeProductsFromRoom()
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