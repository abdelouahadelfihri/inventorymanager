package com.example.inventorymanager.presentation.orders.list

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Clear
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.inventorymanager.presentation.orders.OrdersViewModel
import com.example.inventorymanager.presentation.orders.list.components.OrdersContent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersListScreen(viewModel: OrdersViewModel = hiltViewModel()) {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Deliveries") },
                modifier = Modifier.fillMaxWidth()
            )
        },
        floatingActionButton = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.End,
                modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
            ) {
                FloatingActionButton(onClick = {
                    navController.navigate("add_customer")
                }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
                FloatingActionButton(onClick = {
                    viewModel.onRefreshOrders()
                }) {
                    Icon(Icons.Default.Refresh, contentDescription = "Refresh")
                }
                FloatingActionButton(onClick = {
                    viewModel.onClearSearch()
                }) {
                    Icon(Icons.Default.Clear, contentDescription = "Clear Search")
                }
            }
        }
    ) { innerPadding ->
        OrdersContent(
            viewModel = viewModel,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        )
    }
}