package com.example.inventorymanager.core

class Constants {
    companion object {
        //Room
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
        const val ADD_DELIVERY_SCREEN = "Add Delivery"
        const val ADD_LOCATION_SCREEN = "Add Location"
        const val ADD_ORDER_SCREEN = "Add Order"
        const val ADD_PRODUCT_SCREEN = "Add Product"
        const val ADD_PROVIDER_SCREEN = "Add Provider"
        const val ADD_TRANSFER_SCREEN = "Add Transfer"
        const val ADD_WAREHOUSE_SCREEN = "Add Warehouse"
        const val ADD_CUSTOMER_SCREEN = "Add Customer"

        //Arguments
        const val BOOK_ID = "bookId"

        //Actions
        const val ADD_CUSTOMER = "Add A Customer."
        const val DELETE_CUSTOMER = "Delete a customer."

        //Buttons
        const val ADD_BUTTON = "Add"
        const val DISMISS_BUTTON = "Dismiss"
        const val UPDATE_BUTTON = "Update"

        //Placeholders
        const val AUTHOR = "Type the author name..."
        const val CUSTOMER_NAME = "Customer Name"
        const val CUSTOMER_ADDRESS = "Customer Address"
        const val EMPTY_STRING = ""
    }
}