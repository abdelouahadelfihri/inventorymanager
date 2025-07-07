package com.example.inventorymanager.presentation.ingoings.providers.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.ingoings.providers.ProvidersViewModel
import com.example.inventorymanager.presentation.outs.customers.details.components.UpdateCustomerContent
import com.example.inventorymanager.presentation.outs.customers.details.components.UpdateCustomerTopBar

@Composable
fun UpdateProviderScreen(
    viewModel: ProvidersViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            UpdateCustomerTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            UpdateCustomerContent(
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