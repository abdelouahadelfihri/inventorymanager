package com.example.inventorymanager.presentation.locations.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.locations.LocationsViewModel
import com.example.inventorymanager.presentation.locations.add.components.AddLocationContent
import com.example.inventorymanager.presentation.locations.add.components.AddLocationTopBar

@Composable
fun AddLocationScreen(
    viewModel: LocationsViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AddLocationTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddLocationContent(
                padding = padding,
                location = viewModel.location,
                addLocation = { location ->
                    viewModel.addLocation(location)
                },
                navigateBack = navigateBack
            )
        }
    )
}