package com.example.inventorymanager.presentation.books.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.inventorymanager.domain.model.Customer
import com.example.inventorymanager.presentation.books.CustomersViewModel

@Composable
@ExperimentalMaterialApi
fun CustomersContent(
    padding: PaddingValues,
    viewModel: CustomersViewModel = hiltViewModel(),
    deleteCustomer: (customer: Customer) -> Unit,
    navigateToUpdateCustomerScreen: (customerId: Int) -> Unit
) {

    var searchQuery by remember { mutableStateOf("") }

    val books by viewModel.searchResults.collectAsState()

    TextField(
        value = searchQuery,
        onValueChange = {
            searchQuery = it
            viewModel.searchBooks(it) // Call search function
        },
        label = { Text("Search Books") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        modifier = Modifier.fillMaxWidth()
    )

    Spacer(modifier = Modifier.height(16.dp))

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        items(
            items = books
        ) { book ->
            BookCard(
                book = book,
                deleteBook = {
                    deleteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
        }
    }
}
