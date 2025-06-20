package com.example.inventorymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inventorymanager.ui.theme.DashboardAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardAppTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}

// NAVIGATION
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "dashboard") {
        composable("dashboard") {
            DashboardScreen()
        }
        // Add other routes here if needed
    }
}

// MAIN SCREEN WITH DRAWER & APP BAR
@Composable
fun DashboardScreen() {
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
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Home", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Settings", style = MaterialTheme.typography.h6)
            }
        },
        content = { paddingValues ->
            DashboardContent(modifier = Modifier.padding(paddingValues))
        }
    )
}

// RESPONSIVE DASHBOARD CONTENT
@Composable
fun DashboardContent(modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    if (screenWidth > 600) {
        // Large screen: show cards side by side
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
        // Small screen: show cards in a column
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

// CARD COMPONENT
@Composable
fun DashboardCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    count: Int,
    color: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .height(100.dp),
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