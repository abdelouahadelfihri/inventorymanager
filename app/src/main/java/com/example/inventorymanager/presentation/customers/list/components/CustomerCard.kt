package com.example.inventorymanager.presentation.books.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.presentation.customers.list.DeleteIcon


@Composable
@ExperimentalMaterialApi
fun CustomerCard(
    customer: Customer,
    deleteCustomer: () -> Unit,
    navigateToUpdateCustomerScreen: (customerId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateCustomerScreen(customer.customerId)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(androidx.compose.material3.MaterialTheme.colorScheme.primary)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${customer.customerId}",
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Author",
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Actions",
                modifier = Modifier.weight(1f),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteCustomer = deleteCustomer
            )
        }
    }
}