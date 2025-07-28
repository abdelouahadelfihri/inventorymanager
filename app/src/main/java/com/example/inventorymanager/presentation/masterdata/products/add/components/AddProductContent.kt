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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun AddProductContent(
    padding: PaddingValues,
    product: Product,
    addProduct: (Product) -> Unit,
    navigateBack: () -> Unit
) {
    var code by remember { mutableStateOf(product.code) }
    var barCode by remember { mutableStateOf(product.barCode) }
    var name by remember { mutableStateOf(product.name) }
    var sku by remember { mutableStateOf(product.sku) }
    var category by remember { mutableStateOf(product.category) }
    var unit by remember { mutableStateOf(product.unit) }
    var description by remember { mutableStateOf(product.description) }
    var reorderQuantity by remember { mutableStateOf(product.reorderQuantity) }
    var reorderLevel by remember { mutableStateOf(product.reorderLevel) }
    var packedWeight by remember { mutableStateOf(product.packedWeight) }
    var packedHeight by remember { mutableStateOf(product.packedHeight) }
    var packedWidth by remember { mutableStateOf(product.packedWidth) }
    var packedDepth by remember { mutableStateOf(product.packedDepth) }
    var refrigerated by remember { mutableStateOf(product.refrigerated) }
    var isActive by remember { mutableStateOf(product.isActive) }
    var createdAt by remember { mutableStateOf(product.createdAt) }

    val scrollState = rememberScrollState()
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

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
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Product Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = sku,
                    onValueChange = { sku = it },
                    label = { Text("SKU") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = category.toString(),
                    onValueChange = { category = it.toIntOrNull() ?: 0 },
                    label = { Text("Category") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = unit.toString(),
                    onValueChange = { unit = it.toIntOrNull() ?: 0 },
                    label = { Text("Unit") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = reorderQuantity.toString(),
                    onValueChange = { reorderQuantity = it.toIntOrNull() ?: 0 },
                    label = { Text("Reorder Quantity") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = reorderLevel.toString(),
                    onValueChange = { reorderLevel = it.toIntOrNull() ?: 0 },
                    label = { Text("Reorder Level") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = packedWeight.toString(),
                    onValueChange = { packedWeight = it.toDoubleOrNull() ?: 0.0 },
                    label = { Text("Packed Weight") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = packedHeight.toString(),
                    onValueChange = { packedHeight = it.toDoubleOrNull() ?: 0.0 },
                    label = { Text("Packed Height") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = packedWidth.toString(),
                    onValueChange = { packedWidth = it.toDoubleOrNull() ?: 0.0 },
                    label = { Text("Packed Width") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = packedDepth.toString(),
                    onValueChange = { packedDepth = it.toDoubleOrNull() ?: 0.0 },
                    label = { Text("Packed Depth") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = refrigerated.toString(),
                    onValueChange = { refrigerated = it.toBooleanStrictOrNull() ?: false },
                    label = { Text("Refrigerated (true/false)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = isActive.toString(),
                    onValueChange = { isActive = it.toBooleanStrictOrNull() ?: false },
                    label = { Text("Is Active (true/false)") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = createdAt.format(formatter),
                    onValueChange = {
                        createdAt = try {
                            LocalDateTime.parse(it, formatter)
                        } catch (e: Exception) {
                            createdAt // Don't update if parsing fails
                        }
                    },
                    label = { Text("Created At (yyyy-MM-dd HH:mm:ss)") },
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
                                sku = sku,
                                category = category,
                                unit = unit,
                                description = description,
                                reorderQuantity = reorderQuantity,
                                reorderLevel = reorderLevel,
                                packedWeight = packedWeight,
                                packedHeight = packedHeight,
                                packedWidth = packedWidth,
                                packedDepth = packedDepth,
                                refrigerated = refrigerated,
                                isActive = isActive,
                                createdAt = createdAt
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
                        sku = ""
                        description = ""
                        reorderQuantity = 0
                        reorderLevel = 0
                        packedWeight = 0.0
                        packedHeight = 0.0
                        packedWidth = 0.0
                        packedDepth = 0.0
                        refrigerated = false
                        isActive = false
                        createdAt = LocalDateTime.now()
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