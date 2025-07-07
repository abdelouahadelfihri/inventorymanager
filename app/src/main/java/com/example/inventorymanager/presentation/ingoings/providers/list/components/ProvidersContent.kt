package com.example.inventorymanager.presentation.ingoings.providers.list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.ingoings.Provider
import com.example.inventorymanager.presentation.ingoings.providers.ProvidersViewModel

@Composable
fun ProvidersContent(
    viewModel: ProvidersViewModel,
    modifier: Modifier = Modifier,
    onProviderClick: ((Provider) -> Unit)? = null
) {
    Column(modifier = modifier) {
        // 🔍 Search Bar
        OutlinedTextField(
            value = viewModel.searchQuery,
            onValueChange = viewModel::onSearchChange,
            label = { Text("Search providers...") },
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

        // 📄 Customer List
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp)
        ) {
            items(viewModel.filteredProviders, key = { it.providerId }) { provider ->
                ProviderCard(provider = provider, onClick = { onProviderClick?.invoke(provider) })
            }
        }
    }
}