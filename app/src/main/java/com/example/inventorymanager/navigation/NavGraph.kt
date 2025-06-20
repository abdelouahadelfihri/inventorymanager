package com.example.inventorymanager.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inventorymanager.presentation.customers.list.CustomerListScreen
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
            DashboardScreen() // pass navController if needed for navigation
        }
        composable("customer_list") {
            CustomerListScreen()
        }
        composable("add_customer") {
            AddCustomerScreen()
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