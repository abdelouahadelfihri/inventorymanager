package com.example.inventorymanager.navigation

import com.example.inventorymanager.core.Constants.Companion.BOOKS_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_BOOK_SCREEN

sealed class Screen(val route: String) {
    object BooksScreen: Screen(BOOKS_SCREEN)
    object UpdateBookScreen: Screen(UPDATE_BOOK_SCREEN)
}