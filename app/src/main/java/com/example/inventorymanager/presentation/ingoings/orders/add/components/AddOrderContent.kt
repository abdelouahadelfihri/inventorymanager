package com.example.inventorymanager.presentation.ingoings.orders.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.domain.model.ingoings.Order
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import java.util.Date
import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import androidx.compose.material.icons.filled.Search

@Composable
fun AddOrderContent(
    padding: PaddingValues,
    order: Order,
    addOrder: (Order) -> Unit,
    navigateBack: () -> Unit
) {

    var orderDate by remember { mutableStateOf<Date?>(order.orderDate) }
    var providerId by remember { mutableStateOf(order.providerId.toString()) }

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
                DatePickerField(
                    label = "Sale Date",
                    selectedDate = orderDate,
                    onDateSelected = { orderDate = it }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Customer ID and Select Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = providerId.toString(),
                        onValueChange = { providerId = it },
                        label = { Text("Customer ID") },
                        modifier = Modifier
                            .weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { /* Open customer selection logic here */ },
                        modifier = Modifier
                            .height(56.dp) // Match TextField height
                    ) {
                        Icon(Icons.Default.Search, contentDescription = "Select Customer")
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Select")
                    }
                }
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
                        addOrder(order)
                        navigateBack()
                    }
                ) {
                    Text("Save Customer")
                }

                Button(
                    onClick = {
                        providerId = ""
                        orderDate = null
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
    selectedDate: Date?,               // Nullable Date now
    onDateSelected: (Date) -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance().apply {
        time = selectedDate
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