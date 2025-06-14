package com.example.inventorymanager.presentation.customers.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.presentation.customers.CustomersViewModel
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight


@Composable
@ExperimentalMaterialApi
fun CustomersContent(
    padding: PaddingValues,
    viewModel: CustomersViewModel = hiltViewModel(),
    deleteCustomer: (customer: Customer) -> Unit,
    navigateToUpdateCustomerScreen: (customerId: Int) -> Unit
) {

    var searchQuery by remember { mutableStateOf("") }

    val customers by viewModel.searchResults.collectAsState()

    TextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            viewModel.searchCustomers(it) // Call search function
        },
        label = { Text("Search Books") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Customer Id",
                    modifier = Modifier.weight(1f),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Customer Name",
                    modifier = Modifier.weight(1f),
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        items(
            items = customers
        ) { customer ->
            CustomerCard(
                customer = customer,
                deleteCustomer = {
                    deleteCustomer(customer)
                },
                navigateToUpdateCustomerScreen = navigateToUpdateCustomerScreen
            )
        }
    }
}