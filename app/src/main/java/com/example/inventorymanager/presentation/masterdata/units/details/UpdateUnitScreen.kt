package com.example.inventorymanager.presentation.masterdata.units.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.units.ProvidersViewModel
import com.example.inventorymanager.presentation.masterdata.units.details.components.UpdateUnitContent
import com.example.inventorymanager.presentation.masterdata.units.details.components.UpdateUnitTopBar


@Composable
fun UpdateUnitScreen(
    viewModel: ProvidersViewModel = hiltViewModel(),
    providerId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getProvider(providerId)
    }
    Scaffold(
        topBar = {
            UpdateUnitTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateUnitContent(
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