package com.example.inventorymanager.presentation.masterdata.locations.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.presentation.masterdata.locations.LocationsViewModel

@Composable
fun LocationsContent(
    viewModel: LocationsViewModel,
    modifier: Modifier = Modifier,
    onLocationClick: ((Location) -> Unit)? = null
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

        val locations by viewModel.locations.collectAsState()

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            items(viewModel.filteredLocations, key = { it.locationId }) { location ->
                LocationCard(location = location, onClick = { onLocationClick?.invoke(location) })
            }
        }
    }
}