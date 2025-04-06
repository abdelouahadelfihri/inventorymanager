package com.example.inventorymanager.presentation.customers.add.components

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
import com.example.inventorymanager.domain.model.Customer

@Composable
fun AddCustomerContent(
    padding: PaddingValues,
    customer: Customer,
    addCustomer: (customer: Customer) -> Unit,
    navigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // spacing between fields
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(text = "Enter customer name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = address,
            onValueChange = { address = it },
            placeholder = {
                Text(text = "Enter customer address")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                addCustomer(customer)
                navigateBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Save Customer")
        }
    }

}