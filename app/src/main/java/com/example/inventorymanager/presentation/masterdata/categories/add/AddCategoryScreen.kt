package com.example.inventorymanager.presentation.masterdata.categories.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.categories.CategoriesViewModel
import com.example.inventorymanager.presentation.masterdata.categories.add.components.AddCategoryContent
import com.example.inventorymanager.presentation.masterdata.categories.add.components.AddCategoryTopBar

@Composable
fun AddCategoryScreen(
    viewModel: CategoriesViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AddCategoryTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddCategoryContent(
                padding = padding,
                category = viewModel.category,
                addCategory = { category ->
                    viewModel.addCategory(category)
                },
                navigateBack = navigateBack
            )
        }
    )
}