package com.example.inventorymanager.presentation.masterdata.inventories.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.warehouses.WarehousesViewModel
import com.example.inventorymanager.presentation.masterdata.warehouses.add.components.AddWarehouseContent
import com.example.inventorymanager.presentation.masterdata.warehouses.add.components.AddWarehouseTopBar


@Composable
fun AddWarehouseScreen(
    viewModel: WarehousesViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToProvidersList: () -> Unit
) {
    Scaffold(
        topBar = {
            AddWarehouseTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddWarehouseContent(
                padding = padding,
                warehouse = viewModel.warehouse.value,
                selectedLocation = viewModel.selectedLocation,
                addWarehouse = { warehouse -> viewModel.addWarehouse(warehouse) },
                onSelectLocationClick = navigateToProvidersList,
                navigateBack = navigateBack
            )
        }
    )
}