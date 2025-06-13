package com.example.inventorymanager.presentation.customers.list


import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomerListScreen(viewModel: CustomerViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Customers") },
                modifier = Modifier.fillMaxWidth()
            )
        },
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
            ) {
                FloatingActionButton(onClick = { viewModel.onAddCustomer() }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
                FloatingActionButton(onClick = { viewModel.onRefreshCustomers() }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }
                FloatingActionButton(onClick = { viewModel.onClearCustomers() }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear")
                }
            }
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(8.dp)
            ) {
                // Search Bar
                OutlinedTextField(
                    value = viewModel.searchQuery,
                    onValueChange = viewModel::onSearchChange,
                    label = { Text("Search customers...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                )

                // Filter Row
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

                // Customer List
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    items(viewModel.filteredCustomers) { customer ->
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(text = customer.name, style = MaterialTheme.typography.titleMedium)
                                Text(text = "Type: ${customer.type}", style = MaterialTheme.typography.bodySmall)
                            }
                        }
                    }
                }
            }
        }
    )
}