package com.example.inventorymanager.presentation.delivery.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventorymanager.domain.model.Delivery

@Composable
fun AddDeliveryContent(
    viewModel: CustomerViewModel = viewModel(),
    padding: PaddingValues,
    delivery: Delivery,
    addDelivery: (delivery: Delivery) -> Unit,
    navigateBack: () -> Unit
) {
    val customers by viewModel.customerList.collectAsState()
    var saleDate by remember { mutableStateOf("") }
    var customerId by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        CustomerSelector(
            customerId = selectedCustomerId,
            onCustomerSelected = { selectedCustomerId = it },
            onAddCustomer = {
                // navigate to AddCustomer screen
            },
            customerList = customers.map { it.id } // or name, as you wish
        )

        if (showDialog) {
            CustomerListDialog(
                customers = customers.map { it.name },
                onCustomerSelected = {
                    selectedCustomerId = it
                    showDialog = false
                },
                onDismiss = { showDialog = false }
            )
        }
    }

}


@Composable
fun AddDeliveryScreen() {


    var selectedCustomerId by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }


}