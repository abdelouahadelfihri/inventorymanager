package com.example.inventorymanager.presentation.deliveries.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.customers.CustomersViewModel
import com.example.inventorymanager.presentation.customers.details.components.UpdateCustomerContent
import com.example.inventorymanager.presentation.customers.details.components.UpdateCustomerTopBar

@Composable
fun UpdateCustomerScreen(
    viewModel: CustomersViewModel = hiltViewModel(),
    customerId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getCustomer(customerId)
    }
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