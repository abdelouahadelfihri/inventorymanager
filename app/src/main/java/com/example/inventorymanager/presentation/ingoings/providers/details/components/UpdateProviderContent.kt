package com.example.inventorymanager.presentation.ingoings.providers.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.outgoings.Customer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import com.example.inventorymanager.domain.model.ingoings.Provider

@Composable
fun UpdateProviderContent(
    padding: PaddingValues,
    provider: Provider,
    updateProvider: (Provider) -> Unit,
    deleteProvider: (Int) -> Unit,
    navigateBack: () -> Unit
) {
    var name by remember { mutableStateOf(provider.name) }
    var address by remember { mutableStateOf(provider.address) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Scrollable form
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                OutlinedTextField(
                    value = provider.providerId.toString(),
                    onValueChange = {},
                    label = { Text("Customer ID") },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false
                )


                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = { Text("Customer Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = address,
                    onValueChange = { address = it },
                    label = { Text("Customer Address") },
                    placeholder = { Text("Enter customer address") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    singleLine = false,
                    maxLines = 5,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Default
                    )
                )

            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom fixed buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        updateProvider(provider)
                        navigateBack()
                    }
                ) {
                    Text("Update")
                }

                Button(
                    onClick = {
                        deleteProvider(provider.providerId)
                        navigateBack()
                    }
                ) {
                    Text("Delete")
                }
            }
        }
    }
}