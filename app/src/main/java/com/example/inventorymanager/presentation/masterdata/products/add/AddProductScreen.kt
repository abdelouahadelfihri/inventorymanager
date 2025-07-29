package com.example.inventorymanager.presentation.masterdata.products.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.products.add.components.AddProductContent
import com.example.inventorymanager.presentation.masterdata.products.add.components.AddProductTopBar
import com.example.inventorymanager.presentation.masterdata.products.ProductsViewModel

@Composable
fun AddProductScreen(
    viewModel: ProductsViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    onSelectCategoryClick: () -> Unit,
    onSelectUnitClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AddProductTopBar(navigateBack = navigateBack)
        },
        content = { padding ->
            AddProductContent(
                padding = padding,
                product = viewModel.product,
                addProduct = { product ->
                    viewModel.addProduct(product)
                },
                navigateBack = navigateBack,
                onSelectCategoryClick = onSelectCategoryClick,
                onSelectUnitClick = onSelectUnitClick
            )
        }
    )
}