package com.example.inventorymanager.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp

// --- Colors ---
private val LightColorPalette = lightColors(
    primary = Color(0xFF1E88E5),         // Blue 600
    primaryVariant = Color(0xFF1565C0),  // Blue 800
    secondary = Color(0xFFD81B60),       // Pink 600
    background = Color(0xFFF5F5F5),      // Light gray background
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.Black,
    onSurface = Color.Black,
)

private val DarkColorPalette = darkColors(
    primary = Color(0xFF90CAF9),         // Light Blue 300
    primaryVariant = Color(0xFF64B5F6),  // Light Blue 400
    secondary = Color(0xFFF48FB1),       // Pink 300
    background = Color(0xFF121212),      // Dark background
    surface = Color(0xFF1E1E1E),
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = Color.White,
    onSurface = Color.White,
)

// --- Typography ---
private val AppTypography = Typography(
    h1 = Typography().h1.copy(fontSize = 30.sp, fontWeight = FontWeight.Bold),
    h2 = Typography().h2.copy(fontSize = 24.sp, fontWeight = FontWeight.SemiBold),
    h3 = Typography().h3.copy(fontSize = 20.sp, fontWeight = FontWeight.Medium),
    body1 = Typography().body1.copy(fontSize = 16.sp),
    body2 = Typography().body2.copy(fontSize = 14.sp),
    button = Typography().button.copy(fontWeight = FontWeight.Bold),
    caption = Typography().caption.copy(fontSize = 12.sp, fontFamily = FontFamily.SansSerif)
)

// --- Shapes ---
private val AppShapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(12.dp)
)

@Composable
fun InventoryManagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if(darkTheme) DarkColorPalette else LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}