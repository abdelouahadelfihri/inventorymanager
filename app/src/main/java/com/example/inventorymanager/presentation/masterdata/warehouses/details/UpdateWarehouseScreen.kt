package com.example.inventorymanager.presentation.warehouses.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.warehouses.WarehousesViewModel

@Composable
fun UpdateCustomerScreen(
    viewModel: WarehousesViewModel = hiltViewModel(),
    warehouseId: Int,
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
                customer = viewModel.customer,
                updateCustomer = { customer ->
                    viewModel.updateCustomer(customer)
                },
                deleteCustomer = { customerId ->
                    viewModel.deleteCustomer(customerId)
                },
                navigateBack = navigateBack
            )
        }
    )
}