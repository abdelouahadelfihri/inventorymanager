package com.example.inventorymanager.presentation.masterdata.warehouses.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.ingoings.providers.add.components.AddProviderContent
import com.example.inventorymanager.presentation.ingoings.providers.add.components.AddProviderTopBar
import com.example.inventorymanager.presentation.masterdata.warehouses.WarehousesViewModel
import com.example.inventorymanager.presentation.masterdata.warehouses.add.components.AddWarehouseTopBar
import com.example.inventorymanager.presentation.warehouses.add.components.AddWarehouseContent


@Composable
fun AddWarehouseScreen(
    viewModel: WarehousesViewModel = hiltViewModel(),
    navigateBack: () -> Unit
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
                addWarehouse = { warehouse ->
                    viewModel.addWarehouse(warehouse)
                },
                navigateBack = navigateBack
            )
        }
    )
}