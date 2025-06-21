package com.example.inventorymanager.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inventorymanager.presentation.customers.list.CustomerListScreen
import com.example.inventorymanager.presentation.orders.list.OrdersListScreen
import com.example.inventorymanager.presentation.customers.details.UpdateCustomerScreen
import com.example.inventorymanager.presentation.customers.add.AddCustomerScreen
import com.example.inventorymanager.presentation.dashboard.DashboardScreen

@ExperimentalMaterialApi
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }
        composable("customer_list") {
            CustomerListScreen(navController = navController)
        }
        composable("orders_list") {
            OrdersListScreen(navController = navController)
        }
        composable("add_customer") {
            AddCustomerScreen(
                navigateBack = { navController.popBackStack() }
            )
        }
        composable("update_customer/{customerId}") { backStackEntry ->
            val customerId = backStackEntry.arguments?.getString("customerId")?.toIntOrNull()
            if (customerId != null) {
                UpdateCustomerScreen(
                    customerId = customerId,
                    navigateBack = { navController.popBackStack() }
                )
            }
        }
    }
}