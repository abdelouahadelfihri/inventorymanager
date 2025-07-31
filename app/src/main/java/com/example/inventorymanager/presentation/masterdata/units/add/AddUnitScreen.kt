package com.example.inventorymanager.presentation.masterdata.units.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.providers.ProvidersViewModel
import com.example.inventorymanager.presentation.ingoings.providers.add.components.AddProviderContent
import com.example.inventorymanager.presentation.ingoings.providers.add.components.AddProviderTopBar


@Composable
fun AddUnitScreen(
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