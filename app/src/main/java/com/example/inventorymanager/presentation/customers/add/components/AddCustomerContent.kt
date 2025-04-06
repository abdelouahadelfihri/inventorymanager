package com.example.inventorymanager.presentation.customers.add.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.inventorymanager.core.Constants.Companion.AUTHOR
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_TITLE
import com.example.inventorymanager.core.Constants.Companion.ADD_BUTTON
import com.example.inventorymanager.domain.model.Customer

@Composable
fun AddBookContent(
    padding: PaddingValues,
    customer: Customer,
    updateTitle: (title: String) -> Unit,
    updateAuthor: (author: String) -> Unit,
    addCustomer: (customer: Customer) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = customer.name,
            onValueChange = { title ->
                updateTitle(title)
            },
            placeholder = {
                Text(
                    text = CUSTOMER_NAME
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = customer.address,
            onValueChange = { author ->
                updateAuthor(author)
            },
            placeholder = {
                Text(
                    text = CUSTOMER_ADDRESS
                )
            }
        )
        Button(
            onClick = {
                addCustomer(customer)
                navigateBack()
            }
        ) {
            Text(
                text = ADD_BUTTON
            )
        }
    }
}