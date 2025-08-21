package com.example.inventorymanager.presentation.masterdata.locations.list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.masterdata.Location

@Composable
fun LocationCard(location: Location, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable { onClick() },
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
                    text = "ID: ${location.locationId}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(0.8f)
                )
                Text(
                    text = "Name: ${location.name}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1.2f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "Mobile: ${location.address}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1.2f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}