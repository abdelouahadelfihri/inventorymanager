package com.example.inventorymanager.presentation.ingoings.orders.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.ingoings.orders.OrdersViewModel
import com.example.inventorymanager.presentation.ingoings.orders.details.components.UpdateOrderContent
import com.example.inventorymanager.presentation.ingoings.orders.details.components.UpdateOrderTopBar

@Composable
fun UpdateOrderScreen(
    viewModel: OrdersViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            UpdateOrderTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateOrderContent(
                padding = padding,
                order = viewModel.order,
                selectedProvider = viewModel.selectedProvider,
                updateOrder = { order -> viewModel.updateOrder(order) },
                deleteOrder = { id -> viewModel.deleteOrder(id) },
                onSelectProviderClick = {
                    // Navigate to the provider selection screen
                    // You may call: navController.navigate("select_provider")
                },
                navigateBack = navigateBack
            )
        }
    )
}