package com.example.inventorymanager.presentation.warehouses.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.inventorymanager.presentation.masterdata.warehouses.WarehousesViewModel
import com.example.inventorymanager.presentation.masterdata.warehouses.details.components.UpdateWarehouseContent
import com.example.inventorymanager.presentation.masterdata.warehouses.details.components.UpdateWarehouseTopBar

@Composable
fun UpdateCustomerScreen(
    viewModel: WarehousesViewModel = hiltViewModel(),
    warehouseId: Int,
    navController: NavController,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getWarehouse(warehouseId)
    }
    Scaffold(
        topBar = {
            UpdateWarehouseTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateWarehouseContent(
                padding = padding,
                warehouse = viewModel.warehouse,
                selectedLocation = viewModel.selectedLocation,
                updateWarehouse = { warehouse ->
                    viewModel.updateWarehouse(warehouse)
                },
                deleteWarehouse = { warehouseId ->
                    viewModel.deleteWarehouse(warehouseId)
                },
                onSelectLocationClick = {
                    navController.navigate("")
                },
                navigateBack = navigateBack
            )
        }
    )
}