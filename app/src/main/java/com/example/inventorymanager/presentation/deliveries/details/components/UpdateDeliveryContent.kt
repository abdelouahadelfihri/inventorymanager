package com.example.inventorymanager.presentation.deliveries.update.components

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
import com.example.inventorymanager.domain.model.Delivery
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun UpdateDeliveryContent(
    padding: PaddingValues,
    delivery: Delivery,
    updateDelivery: (Delivery) -> Unit,
    navigateBack: () -> Unit,
    onSelectCustomerClick: () -> Unit // You can hook up navigation or dialog here
) {
    var saleDate by remember { mutableStateOf<Date?>(delivery.saleDate) }
    val customerId = delivery.customerId.toString()
    val deliveryId = delivery.deliveryId.toString()

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
                // Delivery ID
                OutlinedTextField(
                    value = deliveryId,
                    onValueChange = {},
                    label = { Text("Delivery ID") },
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                )

                // Sale Date
                DatePickerField(
                    label = "Sale Date",
                    selectedDate = saleDate,
                    onDateSelected = { saleDate = it }
                )

                // Customer ID + Select Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = customerId,
                        onValueChange = {},
                        label = { Text("Customer ID") },
                        enabled = false,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = onSelectCustomerClick,
                        modifier = Modifier.height(56.dp) // Match TextField height
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Select")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Select")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Bottom buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        saleDate?.let {
                            val updatedDelivery = delivery.copy(saleDate = it)
                            updateDelivery(updatedDelivery)
                            navigateBack()
                        }
                    },
                    enabled = saleDate != null
                ) {
                    Text("Update Delivery")
                }

                Button(
                    onClick = {
                        saleDate = null
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