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
    orderId: Int,
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
                updateOrder = { order ->
                    viewModel.updateOrder(order)
                },
                deleteOrder = { orderId ->
                    viewModel.deleteOrder(orderId)
                },
                navigateBack = navigateBack
            )
        }
    )
}