package com.example.inventorymanager.navigation

import com.example.inventorymanager.core.Constants.Companion.ADD_PROVIDER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_ORDER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_CUSTOMER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_PRODUCT_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_WAREHOUSE_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_TRANSFER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_LOCATION_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ADD_DELIVERY_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_PROVIDER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_ORDER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_CUSTOMER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_PRODUCT_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_WAREHOUSE_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_TRANSFER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_LOCATION_SCREEN
import com.example.inventorymanager.core.Constants.Companion.UPDATE_DELIVERY_SCREEN
import com.example.inventorymanager.core.Constants.Companion.DELIVERY_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.LOCATION_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ORDER_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.PRODUCT_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.PROVIDER_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.TRANSFER_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.WAREHOUSE_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.CUSTOMER_LIST_SCREEN
import com.example.inventorymanager.core.Constants.Companion.SEARCH_SCREEN
import com.example.inventorymanager.core.Constants.Companion.ABOUT_SCREEN
import com.example.inventorymanager.core.Constants.Companion.SETTINGS_SCREEN
import com.example.inventorymanager.core.Constants.Companion.HELP_SCREEN
import com.example.inventorymanager.core.Constants.Companion.LOGOUT_SCREEN
import com.example.inventorymanager.core.Constants.Companion.LOGIN_SCREEN
import com.example.inventorymanager.core.Constants.Companion.REGISTER_SCREEN
import com.example.inventorymanager.core.Constants.Companion.HOME_SCREEN


sealed class Screen(val route: String) {
    object AddProviderScreen: Screen(ADD_PROVIDER_SCREEN)
    object AddOrderScreen: Screen(ADD_ORDER_SCREEN)
    object AddCustomerScreen: Screen(ADD_CUSTOMER_SCREEN)
    object AddProductScreen: Screen(ADD_PRODUCT_SCREEN)
    object AddWarehouseScreen: Screen(ADD_WAREHOUSE_SCREEN)
    object AddTransferScreen: Screen(ADD_TRANSFER_SCREEN)
    object AddLocationScreen: Screen(ADD_LOCATION_SCREEN)
    object AddDeliveryScreen: Screen(ADD_DELIVERY_SCREEN)
    object UpdateProviderScreen: Screen(UPDATE_PROVIDER_SCREEN)
    object UpdateOrderScreen: Screen(UPDATE_ORDER_SCREEN)
    object UpdateCustomerScreen: Screen(UPDATE_CUSTOMER_SCREEN)
    object UpdateProductScreen: Screen(UPDATE_PRODUCT_SCREEN)
    object UpdateWarehouseScreen: Screen(UPDATE_WAREHOUSE_SCREEN)
    object UpdateTransferScreen: Screen(UPDATE_TRANSFER_SCREEN)
    object UpdateLocationScreen: Screen(UPDATE_LOCATION_SCREEN)
    object UpdateDeliveryScreen: Screen(UPDATE_DELIVERY_SCREEN)
    object DeliveryListScreen: Screen(DELIVERY_LIST_SCREEN)
    object LocationListScreen: Screen(LOCATION_LIST_SCREEN)
    object OrderListScreen: Screen(ORDER_LIST_SCREEN)
    object ProductListScreen: Screen(PRODUCT_LIST_SCREEN)
    object ProviderListScreen: Screen(PROVIDER_LIST_SCREEN)
    object TransferListScreen: Screen(TRANSFER_LIST_SCREEN)
    object WarehouseListScreen: Screen(WAREHOUSE_LIST_SCREEN)
    object CustomerListScreen: Screen(CUSTOMER_LIST_SCREEN)
    object SearchScreen: Screen(SEARCH_SCREEN)
    object AboutScreen: Screen(ABOUT_SCREEN)
    object SettingsScreen: Screen(SETTINGS_SCREEN)
    object HelpScreen: Screen(HELP_SCREEN)
    object LogoutScreen: Screen(LOGOUT_SCREEN)
    object LoginScreen: Screen(LOGIN_SCREEN)
    object RegisterScreen: Screen(REGISTER_SCREEN)
    object HomeScreen: Screen(HOME_SCREEN)
}