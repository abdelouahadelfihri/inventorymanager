package com.example.inventorymanager.presentation.outgoings.customers.add

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.presentation.outgoings.customers.CustomersViewModel
import com.example.inventorymanager.presentation.outgoings.customers.add.components.AddCustomerContent
import com.example.inventorymanager.presentation.outgoings.customers.add.components.AddCustomerTopBar


@Composable
fun AddCustomerScreen(
    viewModel: CustomersViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
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