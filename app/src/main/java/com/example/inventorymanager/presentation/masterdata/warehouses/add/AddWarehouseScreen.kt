package com.example.inventorymanager.presentation.masterdata.warehouses.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun AddWarehouseScreen(
    viewModel: ProvidersViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AddProviderTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddProviderContent(
                padding = padding,
                provider = viewModel.provider.value,
                addProvider = { provider ->
                    viewModel.addProvider(provider)
                },
                navigateBack = navigateBack
            )
        }
    )
}