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
import ro.alexmamo.roomjetpackcompose.presentation.customers.CustomersViewModel
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.lazy.items


@Composable
fun CustomerListScreen(viewModel: CustomersViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Customers") },
                modifier = Modifier.fillMaxWidth()
            )
        },
        floatingActionButton = {
            val navController = rememberNavController() // Or pass it from your NavHost

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
            ) {
                // ➕ Add Customer: Navigate to Add Screen
                FloatingActionButton(onClick = {
                    navController.navigate("add_customer") // Example navigation route
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }

                // 🔄 Refresh: Reload from repository
                FloatingActionButton(onClick = {
                    viewModel.onRefreshCustomers()
                }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }

                FloatingActionButton(onClick = {
                    viewModel.onClearSearch()
                }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear Search")
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
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
                ) {
                    items(
                        items = viewModel.filteredCustomers,
                        key = { it.customerId }
                    ) { customer ->
                        // Now `customer` is of type Customer ✅
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {

                                // 🔹 Row 1: ID and Name
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "ID: ${customer.customerId}",
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                    Text(
                                        text = customer.name,
                                        style = MaterialTheme.typography.titleMedium
                                    )
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                // 🔹 Row 2: Type and Contact (or leave contact out if not available)
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "Type: ${customer.type}",
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                    Text(
                                        text = "", // or customer.contact if available
                                        style = MaterialTheme.typography.bodySmall
                                    )
                                }
                            }
                        }

                    }

                }

            }
        }
    )
}