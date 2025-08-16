package com.example.inventorymanager.presentation.masterdata.units.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import com.example.inventorymanager.domain.model.masterdata.MeasurementUnit

@Composable
fun UpdateUnitContent(
    padding: PaddingValues,
    unit: MeasurementUnit,
    updateUnit: (MeasurementUnit) -> Unit,
    deleteUnit: (Int) -> Unit,
    navigateBack: () -> Unit
) {
    var name by remember { mutableStateOf(unit.name) }
    var abbreviation by remember { mutableStateOf(unit.abbreviation) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Scrollable form
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(scrollState),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                OutlinedTextField(
                    value = unit.unitId.toString(),
                    onValueChange = {},
                    label = { Text("Customer ID") },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = false
                )


                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = { Text("Customer Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = abbreviation,
                    onValueChange = {
                        abbreviation = it
                    },
                    label = { Text("Unit Abbreviation") },
                    placeholder = { Text("Enter unit abbreviation") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    singleLine = false,
                    maxLines = 5,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Default
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom fixed buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        updateUnit(unit)
                        navigateBack()
                    }
                ) {
                    Text("Update")
                }

                Button(
                    onClick = {
                        deleteUnit(unit.unitId)
                        navigateBack()
                    }
                ) {
                    Text("Delete")
                }
            }
        }
    }
}