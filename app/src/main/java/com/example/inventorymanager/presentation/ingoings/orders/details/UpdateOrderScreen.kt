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