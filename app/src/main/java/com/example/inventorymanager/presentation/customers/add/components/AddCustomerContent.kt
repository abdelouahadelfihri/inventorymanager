package com.example.inventorymanager.presentation.customers.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.Customer
import androidx.compose.ui.text.input.ImeAction


@Composable
fun AddCustomerContent(
    padding: PaddingValues,
    customer: Customer,
    addCustomer: (customer: Customer) -> Unit,
    navigateBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Customer Name") },
                placeholder = { Text("Enter customer name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Customer Address") },
                placeholder = { Text("Enter customer address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp), // Adjust the height as needed
                singleLine = false,
                maxLines = 5, // Optional: controls the number of visible lines
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Default
                )
            )

        }

        // Row fixed to the bottom of the screen
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    addCustomer(customer)
                    navigateBack()
                }
            ) {
                Text("Save Customer")
            }

            Button(
                onClick = {
                    name = ""
                    address = ""
                }
            ) {
                Text("Clear")
            }
        }
    }

}