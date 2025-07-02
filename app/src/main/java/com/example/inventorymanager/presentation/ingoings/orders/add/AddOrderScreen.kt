package com.example.inventorymanager.presentation.orders.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.deliveries.DeliveriesViewModel
import com.example.inventorymanager.presentation.ingoings.orders.add.components.AddOrderContent
import com.example.inventorymanager.presentation.ingoings.orders.add.components.AddOrderTopBar

@Composable
fun AddDeliveryScreen(
    viewModel: DeliveriesViewModel = hiltViewModel(),
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
                delivery = viewModel.delivery,
                addDelivery = { delivery ->
                    viewModel.addDelivery(delivery)
                },
                navigateBack = navigateBack
            )
        }
    )
}