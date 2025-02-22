package com.example.inventorymanager.presentation.customers.list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
@ExperimentalMaterialApi
fun BooksScreen(
    viewModel: CustomersViewModel = hiltViewModel(),
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    val books by viewModel.books.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            CustomersTopBar()
        },
        content = { padding ->
            CustomersContent(
                padding = padding,
                deleteBook = { book ->
                    viewModel.deleteBook(book)
                },
                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
            AddCustomerAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBook = { book ->
                    viewModel.addBook(book)
                }
            )
        },
        floatingActionButton = {
            AddCustomerFloatingActionButton(
                openDialog = {
                    viewModel.openDialog()
                }
            )
        }
    )
}