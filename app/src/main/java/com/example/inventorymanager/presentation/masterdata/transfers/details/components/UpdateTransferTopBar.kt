package com.example.inventorymanager.presentation.masterdata.transfers.details.components

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun UpdateTransferTopBar(navigateBack: () -> Unit) {
    TopAppBar(
        title = { Text("Add Transfer") },
        navigationIcon = {
            IconButton(onClick = navigateBack) {
                Icon(Icons.Outlined.ArrowBack, contentDescription = "Back")
            }
        }
    )
}