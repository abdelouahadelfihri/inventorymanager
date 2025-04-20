package com.example.inventorymanager.presentation.entitiesselectors

import android.text.Layout.Alignment
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomerSelector(
    customerId: String,
    onCustomerSelected: (String) -> Unit,
    onAddCustomer: () -> Unit,
    customerList: List<String>
) {
    var showCustomerDialog by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = customerId,
            onValueChange = {},
            label = { Text("Customer ID") },
            modifier = Modifier.weight(1f),
            enabled = false
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = {
            if (customerList.isEmpty()) {
                onAddCustomer()
            } else {
                showCustomerDialog = true
            }
        }) {
            Text("Select")
        }
    }

    if (showCustomerDialog) {
        CustomerListDialog(
            customers = customerList,
            onCustomerSelected = {
                onCustomerSelected(it)
                showCustomerDialog = false
            },
            onDismiss = { showCustomerDialog = false }
        )
    }
}