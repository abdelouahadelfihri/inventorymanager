package com.example.inventorymanager.presentation.ingoings.providers.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.ingoings.providers.ProvidersViewModel
import com.example.inventorymanager.presentation.ingoings.providers.details.components.UpdateProviderContent
import com.example.inventorymanager.presentation.ingoings.providers.details.components.UpdateProviderTopBar


@Composable
fun UpdateProviderScreen(
    viewModel: ProvidersViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            UpdateProviderTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateProviderContent(
                padding = padding,
                provider = viewModel.provider,
                updateProvider = { provider ->
                    viewModel.updateProvider(provider)
                },
                deleteProvider = { providerId ->
                    viewModel.deleteProvider(providerId)
                },
                navigateBack = navigateBack
            )
        }
    )
}