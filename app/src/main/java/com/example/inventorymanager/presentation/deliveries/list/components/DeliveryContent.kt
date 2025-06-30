package com.example.inventorymanager.presentation.customers.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.presentation.deliveries.DeliveriesViewModel
import com.example.inventorymanager.presentation.deliveries.list.components.DeliveryCard

@Composable
fun DeliveriesContent(
    viewModel: DeliveriesViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        // 🔍 Search Bar
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = viewModel::onSearchChange,
            label = { Text("Search customers...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // 🔽 Filter Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Filter:", modifier = Modifier.padding(end = 8.dp))
            var expanded by remember { mutableStateOf(false) }

            Box {
                OutlinedButton(onClick = { expanded = true }) {
                    Text(viewModel.selectedFilter)
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    viewModel.filters.forEach { filter ->
                        DropdownMenuItem(
                            text = { Text(filter) },
                            onClick = {
                                viewModel.onFilterSelected(filter)
                                expanded = false
                            }
                        )
                    }
                }
            }
        }

        val customers by viewModel.customers.collectAsState()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            items(viewModel.filteredDeliveries, key = { it.deliveryId }) { delivery ->
                val customerName = customers.find { it.customerId == delivery.customerId }?.name ?: "Unknown"
                DeliveryCard(delivery = delivery, customerName = customerName)
            }
        }
    }
}