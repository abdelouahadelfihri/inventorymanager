package com.example.inventorymanager.presentation.masterdata.inventories.details.components

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.masterdata.Product
import com.example.inventorymanager.domain.model.masterdata.Transfer
import com.example.inventorymanager.domain.model.masterdata.Warehouse
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun UpdateTransferContent(
    padding: PaddingValues,
    transfer: Transfer,
    selectedOriginWarehouse: Warehouse?,
    selectedDestinationWarehouse: Warehouse?,
    selectedProduct: Product?,
    addTransfer: (Transfer) -> Unit,
    onSelectOriginWarehouseClick: () -> Unit,
    onSelectDestinationWarehouseClick: () -> Unit,
    onSelectProductClick: () -> Unit,
    navigateBack: () -> Unit
) {
    var date by remember { mutableStateOf<Date?>(transfer.date) }
    var quantity by remember { mutableStateOf(transfer.quantity.toString()) }

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
                DatePickerField(
                    label = "Transfer Date",
                    selectedDate = date,
                    onDateSelected = { date = it }
                )

                OutlinedTextField(
                    value = quantity,
                    onValueChange = { quantity = it.filter { c -> c.isDigit() } },
                    label = { Text("Quantity") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                WarehouseField(
                    label = "Origin Warehouse",
                    warehouse = selectedOriginWarehouse,
                    onClick = onSelectOriginWarehouseClick
                )

                WarehouseField(
                    label = "Destination Warehouse",
                    warehouse = selectedDestinationWarehouse,
                    onClick = onSelectDestinationWarehouseClick
                )

                ProductField(
                    product = selectedProduct,
                    onClick = onSelectProductClick
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    val finalTransfer = transfer.copy(
                        date = date ?: Date(),
                        quantity = quantity.toIntOrNull() ?: 0,
                        originWarehouseId = selectedOriginWarehouse?.warehouseId ?: transfer.originWarehouseId,
                        destinationWarehouseId = selectedDestinationWarehouse?.warehouseId ?: transfer.destinationWarehouseId,
                        productId = selectedProduct?.productId ?: transfer.productId
                    )
                    addTransfer(finalTransfer)
                    navigateBack()
                }) {
                    Text("Save")
                }

                Button(onClick = {
                    date = null
                    quantity = ""
                }) {
                    Text("Clear")
                }
            }
        }
    }
}

@Composable
fun WarehouseField(label: String, warehouse: Warehouse?, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = warehouse?.let { "${it.warehouseId} - ${it.name}" } ?: "",
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onClick, modifier = Modifier.height(56.dp)) {
            Icon(Icons.Default.Search, contentDescription = "Select $label")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Select")
        }
    }
}

@Composable
fun ProductField(product: Product?, onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        OutlinedTextField(
            value = product?.let { "${it.productId} - ${it.name}" } ?: "",
            onValueChange = {},
            readOnly = true,
            label = { Text("Product") },
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onClick, modifier = Modifier.height(56.dp)) {
            Icon(Icons.Default.Search, contentDescription = "Select Product")
            Spacer(modifier = Modifier.width(4.dp))
            Text("Select")
        }
    }
}

@Composable
fun DatePickerField(label: String, selectedDate: Date?, onDateSelected: (Date) -> Unit) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance().apply {
        time = selectedDate ?: Date()
    }
    val datePickerDialog = remember {
        DatePickerDialog(context, { _, y, m, d ->
            val pickedDate = Calendar.getInstance().apply {
                set(Calendar.YEAR, y)
                set(Calendar.MONTH, m)
                set(Calendar.DAY_OF_MONTH, d)
            }.time
            onDateSelected(pickedDate)
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
    }

    OutlinedTextField(
        value = selectedDate?.toFormattedString() ?: "",
        onValueChange = {},
        readOnly = true,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth()
            .clickable { datePickerDialog.show() },
        trailingIcon = {
            Icon(imageVector = Icons.Default.DateRange, contentDescription = "Pick date")
        }
    )
}

fun Date.toFormattedString(): String {
    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return formatter.format(this)
}