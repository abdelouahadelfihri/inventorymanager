package com.example.inventorymanager.presentation.customers.add.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.example.inventorymanager.core.Constants.Companion.UPDATE_BOOK_SCREEN

@Composable
fun AddDeliveryTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = UPDATE_BOOK_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = navigateBack
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                )
            }
        }
    )
}