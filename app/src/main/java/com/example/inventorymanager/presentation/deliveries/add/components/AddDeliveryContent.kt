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
import com.example.inventorymanager.domain.model.Delivery

@Composable
fun AddDeliveryContent(
    padding: PaddingValues,
    delivery: Delivery,
    addDelivery: (delivery: Delivery) -> Unit,
    navigateBack: () -> Unit
) {
    var saleDate by remember { mutableStateOf("") }
    var customerId by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp) // spacing between fields
    ) {
        TextField(
            value = saleDate,
            onValueChange = { saleDate = it },
            placeholder = {
                Text(text = "Enter customer name")
            },
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = customerId,
            onValueChange = { customerId = it },
            placeholder = {
                Text(text = "Enter customer address")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                addDelivery(delivery)
                navigateBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Delivery")
        }

        Button(
            onClick = {
                addDelivery(delivery)
                navigateBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Add Delivery")
        }
    }

}