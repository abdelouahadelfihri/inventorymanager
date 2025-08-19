package com.example.inventorymanager.presentation.masterdata.warehouses.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.outgoings.Customer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.setValue
import com.example.inventorymanager.domain.model.masterdata.Location
import com.example.inventorymanager.domain.model.masterdata.Warehouse

@Composable
fun UpdateWarehouseContent(
    padding: PaddingValues,
    warehouse: Warehouse,
    selectedLocation: Location?,
    updateWarehouse: (Warehouse) -> Unit,
    deleteWarehouse: (Int) -> Unit,
    onSelectLocationClick: () -> Unit,
    navigateBack: () -> Unit
) {
    val locationId = selectedLocation?.locationId?.toString() ?: warehouse.locationOwnerId.toString()
    val locationName = selectedLocation?.name ?: ""
    val warehouseId = warehouse.warehouseId.toString()
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
                androidx.compose.material.OutlinedTextField(
                    value = warehouseId,
                    onValueChange = {},
                    label = { Text("Warehouse ID") },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                )
                // 🏷️ Warehouse Name
                androidx.compose.material.OutlinedTextField(
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
                        Icon(Icons.Default.Search, contentDescription = "Select Location")
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
                        val finalOwnerId = selectedLocation?.locationId ?: warehouse.locationOwnerId
                        val finalWarehouse = warehouse.copy(
                            name = name,
                            isRefrigerated = if (isRefrigerated) 1 else 0,
                            locationOwnerId = finalOwnerId
                        )
                        updateWarehouse(finalWarehouse)
                        navigateBack()
                    }
                ) {
                    Text("Save Warehouse")
                }

                Button(
                    onClick = {
                        deleteWarehouse(warehouse.warehouseId)
                        navigateBack()
                    }
                ) {
                    androidx.compose.material.Text("Delete")
                }
            }
        }
    }
}