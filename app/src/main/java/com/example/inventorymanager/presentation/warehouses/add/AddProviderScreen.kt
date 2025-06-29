package com.example.inventorymanager.presentation.warehouses.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.providers.ProvidersViewModel
import com.example.inventorymanager.presentation.providers.add.components.AddProviderContent
import com.example.inventorymanager.presentation.providers.add.components.AddProviderTopBar


@Composable
fun AddProviderScreen(
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