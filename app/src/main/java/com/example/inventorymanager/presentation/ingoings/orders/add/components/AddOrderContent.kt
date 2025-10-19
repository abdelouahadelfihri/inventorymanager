package com.example.inventorymanager.presentation.ingoings.orders.add.components

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
import com.example.inventorymanager.domain.model.ingoings.PurchaseOrder
import com.example.inventorymanager.domain.model.ingoings.Supplier
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun AddOrderContent(
    padding: PaddingValues,
    order: PurchaseOrder,
    selectedProvider: Supplier?,
    addOrder: (PurchaseOrder) -> Unit,
    onSelectProviderClick: () -> Unit,
    navigateBack: () -> Unit
) {
    val providerId = selectedProvider?.providerId?.toString() ?: order.providerId.toString()
    val providerName = selectedProvider?.name ?: ""

    var orderDate by remember { mutableStateOf<Date?>(order.orderDate) }

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

                // 📅 Date Picker
                DatePickerField(
                    label = "Order Date",
                    selectedDate = orderDate,
                    onDateSelected = { orderDate = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // 👤 Provider Info and Select
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = "$providerId - $providerName",
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Provider") },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { onSelectProviderClick() },
                        modifier = Modifier.height(56.dp)
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Select Provider")
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
                        val finalProviderId = selectedProvider?.providerId ?: order.providerId
                        val finalOrder = order.copy(
                            providerId = finalProviderId,
                            orderDate = orderDate
                        )
                        addOrder(finalOrder)
                        navigateBack()
                    }
                ) {
                    Text("Save Order")
                }

                Button(
                    onClick = {
                        orderDate = null
                        // You can optionally reset selectedProvider from parent
                    }
                ) {
                    Text("Clear")
                }
            }
        }
    }
}

@Composable
fun DatePickerField(
    label: String,
    selectedDate: Date?,
    onDateSelected: (Date) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance().apply {
        time = selectedDate ?: Date()
    }

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = remember {
        DatePickerDialog(context, { _, y, m, d ->
            val pickedCalendar = Calendar.getInstance().apply {
                set(Calendar.YEAR, y)
                set(Calendar.MONTH, m)
                set(Calendar.DAY_OF_MONTH, d)
            }
            onDateSelected(pickedCalendar.time)
        }, year, month, day)
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
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Select Date"
            )
        }
    )
}

fun Date.toFormattedString(): String {
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    return format.format(this)
}