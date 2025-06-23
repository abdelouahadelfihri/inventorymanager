package com.example.inventorymanager.presentation.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(navController: NavHostController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("Inventory Manager") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        },
        drawerContent = {
            DrawerMenu(
                onItemSelected = { item ->
                    scope.launch { scaffoldState.drawerState.close() }
                    // Handle navigation here if needed
                    when (item) {
                        "Home" -> {} // Already on dashboard
                        "Settings" -> {
                            navController.navigate("settings")
                        }
                    }
                }
            )
        },
        content = { paddingValues ->
            DashboardContent(modifier = Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun DrawerMenu(onSelectItem: (String) -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Header Rectangle with app icon and version
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.LightGray,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Inventory,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Inventory Manager", fontWeight = FontWeight.Bold)
                    Text("v1.0.0", fontSize = 12.sp, color = Color.DarkGray)
                }
            }
        }

        // Selected Store with button
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Store: Main Store", fontWeight = FontWeight.Medium, modifier = Modifier.weight(1f))
            Button(onClick = { onSelectItem("SelectStore") }) {
                Text("Change")
            }
        }

        Divider()

        // Main Menu item
        DrawerItem("Main Menu", Icons.Default.Home) { onSelectItem("MainMenu") }

        Spacer(modifier = Modifier.height(8.dp))
        Divider()

        // Goods, Documents, Expenses, Reports
        DrawerItem("Goods", Icons.Default.Inventory) { onSelectItem("Goods") }
        DrawerItem("Documents", Icons.Default.Description) { onSelectItem("Documents") }
        DrawerItem("Expenses", Icons.Default.Money) { onSelectItem("Expenses") }
        DrawerItem("Reports", Icons.Default.BarChart) { onSelectItem("Reports") }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        // Suppliers, Customers, Stores
        DrawerItem("Suppliers", Icons.Default.People) { onSelectItem("Suppliers") }
        DrawerItem("Customers", Icons.Default.Person) { onSelectItem("Customers") }
        DrawerItem("Stores", Icons.Default.Store) { onSelectItem("Stores") }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        // Settings and Help
        DrawerItem("Settings", Icons.Default.Settings) { onSelectItem("Settings") }
        DrawerItem("Help", Icons.Default.Info) { onSelectItem("Help") }
    }
}

@Composable
fun DrawerItem(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = 12.dp)
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text, fontSize = 16.sp)
    }
}

@Composable
fun DashboardContent(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    if (screenWidth > 600) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DashboardCard(
                title = "Goods",
                icon = Icons.Default.Inventory,
                count = 15,
                color = Color.Green,
                modifier = Modifier.weight(1f)
            )
            DashboardCard(
                title = "Documents",
                icon = Icons.Default.Description,
                count = 7,
                color = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DashboardCard(
                title = "Goods",
                icon = Icons.Default.Inventory,
                count = 15,
                color = Color.Green,
                modifier = Modifier.fillMaxWidth()
            )
            DashboardCard(
                title = "Documents",
                icon = Icons.Default.Description,
                count = 7,
                color = Color.LightGray,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun DashboardCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.height(100.dp),
        backgroundColor = color,
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(icon, contentDescription = title, tint = Color.White)
            Text(title, color = Color.White)
            Text(count.toString(), color = Color.White)
        }
    }
}