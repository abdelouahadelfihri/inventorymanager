package com.example.inventorymanager.core

class Constants {
    companion object {
        //Room
        const val BOOK_TABLE = "book"
        const val PROVIDER_TABLE = "provider"
        const val CUSTOMER_TABLE = "customer"
        const val INVENTORY_TABLE = "inventory"
        const val PRODUCT_TABLE = "product"
        const val ORDER_TABLE = "order"
        const val TRANSFER_TABLE = "transfer"
        const val WAREHOUSE_TABLE = "warehouse"
        const val LOCATION_TABLE = "location"
        const val DELIVERY_TABLE = "delivery"
        const val DELIVERY_DETAILS_TABLE = "delivery_details"
        const val ORDER_DETAILS_TABLE = "order_details"

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