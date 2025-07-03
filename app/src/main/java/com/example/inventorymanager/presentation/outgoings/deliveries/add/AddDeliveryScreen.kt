package com.example.inventorymanager.presentation.outgoings.deliveries.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.deliveries.DeliveriesViewModel
import com.example.inventorymanager.presentation.deliveries.add.components.AddDeliveryContent
import com.example.inventorymanager.presentation.deliveries.add.components.AddDeliveryTopBar

@Composable
fun AddDeliveryScreen(
    viewModel: DeliveriesViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            AddDeliveryTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddDeliveryContent(
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