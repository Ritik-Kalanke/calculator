package com.example.calculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun CalculatorAppTheme(content: @Composable () -> Unit) {
    val darkColorScheme = darkColorScheme(
        primary = Color(0xFFBB86FC),  // Light Purple
        secondary = Color(0xFF03DAC6),  // Teal
        background = Color(0xFF121212),  // Dark background
        surface = Color(0xFF121212),  // Dark surface
        onPrimary = Color.Black,
        onSecondary = Color.Black,
        onBackground = Color.White,
        onSurface = Color.White
    )

    val lightColorScheme = lightColorScheme(
        primary = Color(0xFF6200EE),  // Deep Purple
        secondary = Color(0xFF03DAC6),  // Teal
        background = Color(0xFFFFFFFF),  // White background
        surface = Color(0xFFFFFFFF),  // White surface
        onPrimary = Color.White,
        onSecondary = Color.Black,
        onBackground = Color.Black,
        onSurface = Color.Black
    )

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme else lightColorScheme,
        typography = Typography,
        content = content
    )
}

