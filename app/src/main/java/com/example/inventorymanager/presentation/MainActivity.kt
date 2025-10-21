package com.example.inventorymanager.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventorymanager.ui.theme.InventoryManagerTheme
import androidx.activity.ComponentActivity
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
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.ViewList
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

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
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Home.route) { InsScreen() }
            composable(BottomNavItem.Search.route) { OutsScreen() }
            composable(BottomNavItem.Profile.route) { CatalogScreen() }
        }
    }
}

sealed class BottomNavItem(val route: String, val label: String, val icon: @Composable () -> Unit) {
    object Home : BottomNavItem("home", "Home", { Icon(Icons.Filled.Home, contentDescription = "Home") })
    object Search : BottomNavItem("search", "Search", { Icon(Icons.Filled.Search, contentDescription = "Search") })
    object Profile : BottomNavItem("profile", "Profile", { Icon(Icons.Filled.Person, contentDescription = "Profile") })
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Search,
        BottomNavItem.Profile
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
fun InsScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Text(text = "🏠 Home Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun OutsScreen() {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Text(text = "🔍 Search Screen", style = MaterialTheme.typography.headlineMedium)
    }
}

@Composable
fun CatalogScreen() {
    val catalogItems = listOf(
        CatalogItem("Category", Icons.Default.Category),
        CatalogItem("Customer", Icons.Default.People),
        CatalogItem("Document", Icons.Default.ViewList),
        CatalogItem("Inventory", Icons.Default.Inventory),
        CatalogItem("Location", Icons.Default.LocationOn),
        CatalogItem("Units", Icons.Default.SwapHoriz),
        CatalogItem("Product", Icons.Default.ShoppingCart),
        CatalogItem("Supplier", Icons.Default.Store),
        CatalogItem("Warehouse", Icons.Default.Inventory)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(catalogItems) { item ->
                CatalogCard(item)
            }
        }
    }
}

@Composable
fun CatalogCard(item: CatalogItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.2f), // Keeps card square-like
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
                imageVector = item.icon,
                contentDescription = item.label,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = item.label,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

data class CatalogItem(
    val label: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)