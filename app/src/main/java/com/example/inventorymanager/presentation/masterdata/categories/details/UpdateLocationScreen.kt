package com.example.inventorymanager.presentation.masterdata.categories.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.locations.LocationsViewModel
import com.example.inventorymanager.presentation.masterdata.locations.details.components.UpdateLocationContent
import com.example.inventorymanager.presentation.masterdata.locations.details.components.UpdateLocationTopBar

@Composable
fun UpdateLocationScreen(
    viewModel: LocationsViewModel = hiltViewModel(),
    locationId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getLocation(locationId)
    }
    Scaffold(
        topBar = {
            UpdateLocationTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateLocationContent(
                padding = padding,
                location = viewModel.location,
                updateLocation = { location ->
                    viewModel.updateLocation(location)
                },
                deleteLocation = { locationId ->
                    viewModel.deleteLocation(locationId)
                },
                navigateBack = navigateBack
            )
        }
    )
}