package com.example.inventorymanager.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inventorymanager.presentation.orders.list.OrdersListScreen
import com.example.inventorymanager.presentation.outs.customers.details.UpdateCustomerScreen
import com.example.inventorymanager.presentation.outs.customers.add.AddCustomerScreen
import com.example.inventorymanager.presentation.dashboard.DashboardScreen
import com.example.inventorymanager.presentation.ingoings.orders.OrdersViewModel
import com.example.inventorymanager.presentation.ingoings.orders.add.AddOrderScreen
import com.example.inventorymanager.presentation.ingoings.providers.list.ProvidersListScreen
import com.example.inventorymanager.presentation.locations.list.LocationsListScreen
import com.example.inventorymanager.presentation.outgoings.customers.list.CustomersListScreen

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
            CustomersListScreen()
        }
        composable("orders_list") {
            OrdersListScreen()
        }
        composable("locations_list"){
            LocationsListScreen()
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

        composable("add_order") {
            AddOrderScreen(
                navigateBack = { navController.popBackStack() },
                navigateToProvidersList = { navController.navigate("providers_list") }
            )
        }

        composable("providers_list") {
            val orderViewModel: OrdersViewModel = hiltViewModel() // ✅ Safe here inside a @Composable scope

            ProvidersListScreen(
                onProviderSelected = { provider ->
                    orderViewModel.onProviderSelected(provider)
                    navController.popBackStack() // Navigate back to AddOrderScreen
                }
            )
        }

    }
}