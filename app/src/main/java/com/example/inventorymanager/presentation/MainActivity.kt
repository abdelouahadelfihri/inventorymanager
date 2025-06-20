package com.example.inventorymanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.rememberNavController
import com.example.inventorymanager.navigation.AppNavHost
import com.example.inventorymanager.ui.theme.InventoryManagerTheme

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryManagerTheme {
                val navController = rememberNavController()
                AppNavHost(navController = navController)
            }
        }
    }
}