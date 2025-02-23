package com.example.inventorymanager.presentation.customers.list

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.example.inventorymanager.core.Constants.Companion.DELETE_CUSTOMER

@Composable
fun DeleteIcon(
    deleteCustomer: () -> Unit
) {
    IconButton(
        onClick = deleteCustomer
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_CUSTOMER,
        )
    }
}