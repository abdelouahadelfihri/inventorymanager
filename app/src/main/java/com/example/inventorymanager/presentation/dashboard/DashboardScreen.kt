package com.example.inventorymanager.presentation.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Store
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
            DrawerMenu(onSelectItem = { item ->
                scope.launch { scaffoldState.drawerState.close() }
                navController.navigate(item)
            })
        },
        content = { paddingValues ->
            DashboardContent(modifier = Modifier.padding(paddingValues))
        }
    )
}

@Composable
fun DrawerMenu(onSelectItem: (String) -> Unit) {
    var showIns by remember { mutableStateOf(false) }
    var showOuts by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.LightGray,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(12.dp)
            ) {
                Icon(Icons.Default.Inventory, contentDescription = null, modifier = Modifier.size(40.dp))
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text("Inventory Manager")
                    Text("v1.0.0", fontSize = 12.sp, color = Color.DarkGray)
                }
            }
        }

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
        DrawerItem("Main Menu", Icons.Default.Home) { onSelectItem("MainMenu") }
        Divider(modifier = Modifier.padding(vertical = 8.dp))

        // INS group
        DrawerItem("Ingoings", Icons.Default.ArrowDownward) { showIns = !showIns }
        if (showIns) {
            DrawerSubItem("Providers") { onSelectItem("Providers") }
            DrawerSubItem("Orders") { onSelectItem("Orders") }
            DrawerSubItem("Purchases Receipts") { onSelectItem("Purchases Receipts") }

        }

        // OUTS group
        DrawerItem("Outgoings", Icons.Default.ArrowUpward) { showOuts = !showOuts }
        if (showOuts) {
            DrawerSubItem("Customers") { onSelectItem("Customers") }
            DrawerSubItem("Deliveries") { onSelectItem("Deliveries") }
        }

        DrawerItem("Master Data", Icons.Default.ArrowUpward) { showOuts = !showOuts }
        if (showOuts) {
            DrawerSubItem("Customers") { onSelectItem("Customers") }
            DrawerSubItem("Deliveries") { onSelectItem("Deliveries") }
        }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        DrawerItem("Warehouses", Icons.Default.Inventory) { onSelectItem("Warehouses") }
        DrawerItem("Transfers", Icons.Default.Inventory) { onSelectItem("Transfers") }
        DrawerItem("Locations", Icons.Default.Inventory) { onSelectItem("Locations") }
        DrawerItem("Inventories", Icons.Default.Inventory) { onSelectItem("Inventories") }
        DrawerItem("Products", Icons.Default.Inventory) { onSelectItem("Products") }
        DrawerItem("Documents", Icons.Default.Description) { onSelectItem("Documents") }
        DrawerItem("Expenses", Icons.Default.Money) { onSelectItem("Expenses") }
        DrawerItem("Reports", Icons.Default.BarChart) { onSelectItem("Reports") }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

        DrawerItem("Suppliers", Icons.Default.People) { onSelectItem("Suppliers") }
        DrawerItem("Customers", Icons.Default.Person) { onSelectItem("Customers") }
        DrawerItem("Stores", Icons.Default.Store) { onSelectItem("Stores") }

        Divider(modifier = Modifier.padding(vertical = 8.dp))

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
fun DrawerSubItem(text: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(start = 48.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Text(text, fontSize = 15.sp)
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