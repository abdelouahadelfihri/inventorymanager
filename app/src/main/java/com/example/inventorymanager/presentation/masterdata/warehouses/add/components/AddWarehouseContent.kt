package com.example.inventorymanager.presentation.warehouses.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@Composable
fun AddWarehouseContent(
    padding: PaddingValues,
    warehouse: Warehouse,
    selectedLocation: Location?, // your Owner model
    addWarehouse: (Warehouse) -> Unit,
    onSelectLocationClick: () -> Unit,
    navigateBack: () -> Unit
) {
    val locationId = selectedLocation?.locationId?.toString() ?: warehouse.locationOwnerId.toString()
    val locationName = selectedLocation?.name ?: ""
    var name by remember { mutableStateOf(warehouse.name) }
    var isRefrigerated by remember { mutableStateOf(warehouse.isRefrigerated == 1) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 🏷️ Warehouse Name
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Warehouse Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                // ❄️ Refrigerated Checkbox
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isRefrigerated,
                        onCheckedChange = { isRefrigerated = it }
                    )
                    Text("Refrigerated")
                }

                // 📍 Location Owner
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = "$locationId - $locationName",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Location Owner") },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { onSelectLocationClick() },
                        modifier = Modifier.height(56.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Select Owner")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Select")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 💾 Save & Clear
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        val finalWarehouse = warehouse.copy(
                            name = name,
                            isRefrigerated = if (isRefrigerated) 1 else 0
                            // locationOwnerId can be updated by parent when owner is selected
                        )
                        addWarehouse(finalWarehouse)
                        navigateBack()
                    }
                ) {
                    Text("Save Warehouse")
                }

                Button(
                    onClick = {
                        name = ""
                        isRefrigerated = false
                        // Optionally reset owner from parent
                    }
                ) {
                    Text("Clear")
                }
            }
        }
    }
}