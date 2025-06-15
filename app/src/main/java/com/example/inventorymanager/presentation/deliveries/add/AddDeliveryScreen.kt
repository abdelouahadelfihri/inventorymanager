package com.example.inventorymanager.presentation.deliveries.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.customers.CustomersViewModel
import com.example.inventorymanager.presentation.deliveries.add.components.AddDeliveryContent
import com.example.inventorymanager.presentation.deliveries.add.components.AddDeliveryTopBar

@Composable
fun AddDeliveryScreen(
    viewModel: CustomersViewModel = hiltViewModel(),
    customerId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getCustomer(customerId)
    }
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