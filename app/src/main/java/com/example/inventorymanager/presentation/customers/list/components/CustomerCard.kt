package com.example.inventorymanager.presentation.customers.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.Customer

@Composable
fun CustomerCard(customer: Customer) {
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

            // 🔹 Row 2: Mobile and Phone
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Mobile: ${customer.mobile}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "Phone: ${customer.phone}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}