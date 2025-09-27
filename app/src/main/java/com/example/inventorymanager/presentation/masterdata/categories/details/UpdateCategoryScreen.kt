package com.example.inventorymanager.presentation.masterdata.categories.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.categories.CategoriesViewModel
import com.example.inventorymanager.presentation.masterdata.categories.details.components.UpdateCategoryContent
import com.example.inventorymanager.presentation.masterdata.categories.details.components.UpdateCategoryTopBar
import com.example.inventorymanager.presentation.masterdata.locations.LocationsViewModel
import com.example.inventorymanager.presentation.masterdata.locations.details.components.UpdateLocationContent
import com.example.inventorymanager.presentation.masterdata.locations.details.components.UpdateLocationTopBar

@Composable
fun UpdateCategoryScreen(
    viewModel: CategoriesViewModel = hiltViewModel(),
    categoryId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getCategory(categoryId)
    }
    Scaffold(
        topBar = {
            UpdateCategoryTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateCategoryContent(
                padding = padding,
                category = viewModel.category,
                updateCategory = { category ->
                    viewModel.updateCategory(category)
                },
                deleteCategory = { categoryId ->
                    viewModel.deleteCategory(categoryId)
                },
                navigateBack = navigateBack
            )
        }
    )
}