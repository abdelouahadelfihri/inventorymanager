package com.example.inventorymanager.presentation.outgoings.customers.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.masterdata.Customer

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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "ID: ${customer.customerId}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(0.8f)
                )
                Text(
                    text = customer.name,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1.2f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Mobile: ${customer.mobile}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1.2f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}