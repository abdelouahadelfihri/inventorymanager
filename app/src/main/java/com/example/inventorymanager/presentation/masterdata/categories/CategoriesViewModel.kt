package com.example.inventorymanager.presentation.masterdata.categories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.inventorymanager.domain.model.masterdata.Category
import com.example.inventorymanager.domain.repository.masterdata.CategoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val repo: CategoryRepository
) : ViewModel() {

    private val _categories = MutableStateFlow<List<Category>>(emptyList())
    val categories: StateFlow<List<Category>> = _categories

    var selectedFilter by mutableStateOf("All")
    var filters = listOf("All", "Category 1", "Category 2")
    var category by mutableStateOf(
        Category(
            id = 0,
            name = "", // or any default Date, like SimpleDateFormat().parse("1970-01-01")
            description = ""
        )
    )
        private set

    var openDialog by mutableStateOf(false)

    var searchQuery by mutableStateOf("")

    fun getCategory(id: Int) = viewModelScope.launch {
        category = repo.getCategoryFromRoom(id)
    }

    init {
        observeCategoriesFromRoom()
    }

    fun addCategory(category: Category) = viewModelScope.launch {
        repo.addCategoryToRoom(category)
    }

    fun updateCategory(category: Category) = viewModelScope.launch {
        repo.updateCategoryInRoom(category)
    }

    fun deleteCategory(id: Int) = viewModelScope.launch {
        repo.deleteCategoryFromRoom(id)
    }

    fun openDialog() {
        openDialog = true
    }

    fun closeDialog() {
        openDialog = false
    }

    private fun observeCategoriesFromRoom() {
        viewModelScope.launch {
            repo.getCategoriesFromRoom()
                .collect { list ->
                    _categories.value = list
                }
        }
    }

    val filteredCategories: List<Category>
        get() {
            val terms = searchQuery
                .trim()
                .lowercase()
                .split(";")
                .map { it.trim() }
                .filter { it.isNotEmpty() }

            return _categories.value.filter { category ->
                terms.any { term ->
                    category.id.toString().contains(term) ||
                            category.name.toString().lowercase().contains(term) ||
                            category.description.toString().contains(term)
                }
            }
        }

    // Optional: Triggered by Refresh FAB
    fun onRefreshCategories() {
        // This is optional if Room is live. But you can re-collect:
        observeCategoriesFromRoom()
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