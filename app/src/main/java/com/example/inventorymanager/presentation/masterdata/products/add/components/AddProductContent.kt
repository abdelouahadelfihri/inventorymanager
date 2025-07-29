package com.example.inventorymanager.presentation.masterdata.products.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.masterdata.Product
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun AddProductContent(
    padding: PaddingValues,
    product: Product,
    addProduct: (Product) -> Unit,
    navigateBack: () -> Unit,
    onSelectCategoryClick: () -> Unit,
    onSelectUnitClick: () -> Unit
) {
    var name by remember { mutableStateOf(product.name) }
    var code by remember { mutableStateOf(product.code) }
    var barCode by remember { mutableStateOf(product.barCode) }
    var category by remember { mutableStateOf(product.category) }
    var unit by remember { mutableStateOf(product.unit) }
    var reorderLevel by remember { mutableStateOf(product.reorderLevel) }
    var isActive by remember { mutableStateOf(product.isActive) }

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
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Product Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = code,
                    onValueChange = { code = it },
                    label = { Text("Product Code") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = barCode,
                    onValueChange = { barCode = it },
                    label = { Text("Bar Code") },
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = category.toString(),
                        onValueChange = { category = it.toIntOrNull() ?: 0 },
                        label = { Text("Category") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { onSelectCategoryClick() },
                        modifier = Modifier.height(56.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Select Category")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Select")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = unit.toString(),
                        onValueChange = { unit = it.toIntOrNull() ?: 0 },
                        label = { Text("Unit") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { onSelectUnitClick() },
                        modifier = Modifier.height(56.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Select Unit")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Select")
                    }
                }

                OutlinedTextField(
                    value = unit.toString(),
                    onValueChange = { unit = it.toIntOrNull() ?: 0 },
                    label = { Text("Unit") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = reorderLevel.toString(),
                    onValueChange = { reorderLevel = it.toIntOrNull() ?: 0 },
                    label = { Text("Reorder Level") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = isActive.toString(),
                    onValueChange = { isActive = it.toBooleanStrictOrNull() ?: false },
                    label = { Text("Is Active (true/false)") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom fixed buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        addProduct(
                            Product(
                                productId = product.productId,
                                code = code,
                                barCode = barCode,
                                name = name,
                                category = category,
                                unit = unit,
                                reorderLevel = reorderLevel,
                                isActive = isActive
                            )
                        )
                        navigateBack()
                    }
                ) {
                    Text("Save Product")
                }

                Button(
                    onClick = {
                        code = ""
                        barCode = ""
                        reorderLevel = 0
                        isActive = false
                        category = 0
                        unit = 0
                        name = ""
                    }
                ) {
                    Text("Clear")
                }
            }
        }
    }
}