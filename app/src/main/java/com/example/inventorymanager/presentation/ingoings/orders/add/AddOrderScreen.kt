package com.example.inventorymanager.presentation.ingoings.orders.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.ingoings.orders.OrdersViewModel
import com.example.inventorymanager.presentation.ingoings.orders.add.components.AddOrderContent
import com.example.inventorymanager.presentation.ingoings.orders.add.components.AddOrderTopBar

@Composable
fun AddOrderScreen(
    viewModel: OrdersViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AddOrderTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddOrderContent(
                padding = padding,
                order = viewModel.order,
                addOrder = { order ->
                    viewModel.addOrder(order)
                },
                navigateBack = navigateBack
            )
        }
    )
}