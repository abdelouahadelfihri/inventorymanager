package com.example.inventorymanager.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inventorymanager.presentation.customers.list.CustomerListScreen
import com.example.inventorymanager.presentation.customers.details.UpdateCustomerScreen
import com.example.inventorymanager.presentation.customers.add.AddCustomerScreen
import androidx.navigation.compose.rememberNavController


@ExperimentalMaterialApi
@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = "customer_list"
    ) {
        composable("customer_list") {
            CustomerListScreen(navController)
        }
        composable("add_customer") {
            AddCustomerScreen(navController)
        }
        composable("update_customer/{customerId}") { backStackEntry ->
            val customerId = backStackEntry.arguments?.getString("customerId")?.toIntOrNull()
            if (customerId != null) {
                UpdateCustomerScreen(navController, customerId)
            }
        }
    }
}