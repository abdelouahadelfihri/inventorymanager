package com.example.inventorymanager.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventorymanager.ui.theme.InventoryManagerTheme
import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import com.example.inventorymanager.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryManagerTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Catalog.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Catalog.route) { catalogScreen() }
            composable(BottomNavItem.StockOutflow.route) { stockOutflowScreen() }
            composable(BottomNavItem.StockInflow.route) { stockInflowScreen() }
        }
    }
}

sealed class BottomNavItem(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Catalog : BottomNavItem("catalog", "Catalog", { Icon(Icons.Filled.Home, contentDescription = "Catalog") })
    object StockInflow : BottomNavItem("stockInflow", "Stock Inflow", { Icon(Icons.Filled.Search, contentDescription = "Stock Inflow") })
    object StockOutflow : BottomNavItem("stockOutflow", "Stock Outflow", { Icon(Icons.Filled.Person, contentDescription = "Stock Outflow") })
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Catalog,
        BottomNavItem.StockInflow,
        BottomNavItem.StockOutflow
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        items.forEach { item ->
            val selected = currentDestination?.route == item.route
            NavigationBarItem(
                icon = { item.icon() },
                label = { Text(item.label) },
                selected = selected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun stockInflowScreen() {
    val items = listOf(
        MenuItem("Purchases Orders", R.drawable.purchasesorders),
        MenuItem("Purchases Receipts", R.drawable.purchasesreceipts),
        MenuItem("Supplier Returns", R.drawable.ordersreturns),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            MenuCard(label = item.label, iconRes = item.iconRes) {
                // handle click
            }
        }
    }
}

@Composable
fun stockOutflowScreen() {
    val items = listOf(
        MenuItem("Sales Orders", R.drawable.salesorders),
        MenuItem("Deliveries", R.drawable.deliveries),
        MenuItem("Sales Returns", R.drawable.ordersreturns),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            MenuCard(label = item.label, iconRes = item.iconRes) {
                // handle click
            }
        }
    }
}

@Composable
fun catalogScreen() {
    val items = listOf(
        MenuItem("Category", R.drawable.categories),
        MenuItem("Customer", R.drawable.customers),
        MenuItem("Product", R.drawable.products),
        MenuItem("Supplier", R.drawable.ic_supplier),
        MenuItem("Units", R.drawable.ic_units),
        MenuItem("Warehouse", R.drawable.ic_warehouse),
        MenuItem("Location", R.drawable.ic_location),
        MenuItem("Document", R.drawable.ic_document)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(items) { item ->
            MenuCard(label = item.label, iconRes = item.iconRes) {
                // handle click
            }
        }
    }
}

@Composable
fun MenuCard(
    label: String,
    iconRes: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.2f)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = label, style = MaterialTheme.typography.titleMedium)
        }
    }
}

data class MenuItem(
    val label: String,
    val iconRes: Int  // resource ID of the drawable (R.drawable.ic_product)
)