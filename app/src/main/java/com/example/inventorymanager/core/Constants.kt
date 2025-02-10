package com.example.inventorymanager.core

class Constants {
    companion object {
        //Room
        const val BOOK_TABLE = "book_table"
        const val PROVIDER_TABLE = "provider_table"
        const val INVENTORY_TABLE = "inventory_table"
        const val PRODUCT_TABLE = "product_table"
        const val ORDER_TABLE = "order_table"
        const val WAREHOUSE_TABLE = "warehouse_table"

        //Screens
        const val BOOKS_SCREEN = "Books"
        const val UPDATE_BOOK_SCREEN = "Update book"

        //Arguments
        const val BOOK_ID = "bookId"

        //Actions
        const val ADD_BOOK = "Add a book."
        const val DELETE_BOOK = "Delete a book."

        //Buttons
        const val ADD_BUTTON = "Add"
        const val DISMISS_BUTTON = "Dismiss"
        const val UPDATE_BUTTON = "Update"

        //Placeholders
        const val BOOK_TITLE = "Type a book title..."
        const val AUTHOR = "Type the author name..."
        const val EMPTY_STRING = ""
    }
}