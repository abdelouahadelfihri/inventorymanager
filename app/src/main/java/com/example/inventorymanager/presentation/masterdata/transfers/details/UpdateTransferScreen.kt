package com.example.inventorymanager.presentation.masterdata.transfers.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.masterdata.transfers.TransfersViewModel
import com.example.inventorymanager.presentation.transfers.add.components.AddTransferTopBar
import com.example.inventorymanager.presentation.transfers.add.components.AddTransferContent

@Composable
fun UpdateTransferScreen(
    viewModel: TransfersViewModel = hiltViewModel(),
    navigateBack: () -> Unit,
    navigateToSelectWarehouseOrigin: () -> Unit,
    navigateToSelectWarehouseDestination: () -> Unit,
    navigateToSelectProduct: () -> Unit
) {
    Scaffold(
        topBar = { AddTransferTopBar(navigateBack = navigateBack) },
        content = { padding ->
            AddTransferContent(
                padding = padding,
                transfer = viewModel.transfer,
                selectedOriginWarehouse = viewModel.selectedOriginWarehouse,
                selectedDestinationWarehouse = viewModel.selectedDestinationWarehouse,
                selectedProduct = viewModel.selectedProduct,
                addTransfer = { viewModel.addTransfer(it) },
                onSelectOriginWarehouseClick = navigateToSelectWarehouseOrigin,
                onSelectDestinationWarehouseClick = navigateToSelectWarehouseDestination,
                onSelectProductClick = navigateToSelectProduct,
                navigateBack = navigateBack
            )
        }
    )
}