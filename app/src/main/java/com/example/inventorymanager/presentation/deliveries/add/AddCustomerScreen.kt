package com.example.inventorymanager.presentation.deliveries.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.customers.CustomersViewModel
import com.example.inventorymanager.presentation.customers.add.components.AddCustomerContent
import com.example.inventorymanager.presentation.customers.add.components.AddCustomerTopBar


@Composable
fun AddCustomerScreen(
    viewModel: CustomersViewModel = hiltViewModel(),
    customerId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getCustomer(customerId)
    }
    Scaffold(
        topBar = {
            AddCustomerTopBar(
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            AddCustomerContent(
                padding = padding,
                customer = viewModel.customer,
                addCustomer = { customer ->
                    viewModel.addCustomer(customer)
                },
                navigateBack = navigateBack
            )
        }
    )
}