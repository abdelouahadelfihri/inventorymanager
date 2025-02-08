package ro.alexmamo.roomjetpackcompose.presentation.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
@ExperimentalMaterialApi
fun MainScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent { coroutineScope.launch { drawerState.close() } }
        }
    ) {
        Scaffold(
            topBar = { MyToolbar { coroutineScope.launch { drawerState.open() } } }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                ClickableBar { /* Handle Click Action */ }
                ButtonGrid()
            }
        }
    }
}

@Composable
fun MyToolbar(onMenuClick: () -> Unit) {
    TopAppBar(
        title = { Text("My App") },
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle settings click */ }) {
                Icon(Icons.Filled.Settings, contentDescription = "Settings")
            }
        }
    )
}

@Composable
fun ClickableBar(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(Color.Gray)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text("Click Me", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ButtonGrid() {
    val buttons = listOf("Button 1", "Button 2", "Button 3", "Button 4", "Button 5", "Button 6")

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(buttons) { buttonText ->
            Button(
                onClick = { /* Handle Button Click */ },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            ) {
                Text(buttonText)
            }
        }
    }
}

@Composable
fun DrawerContent(onItemClick: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Home", modifier = Modifier.clickable { onItemClick() })
        Spacer(modifier = Modifier.height(8.dp))
        Text("Settings", modifier = Modifier.clickable { onItemClick() })
    }
}