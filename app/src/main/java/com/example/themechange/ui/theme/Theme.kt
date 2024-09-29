package com.example.themechange.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


private val DarkColorScheme = darkColorScheme(
    primary = Verdigris,
    secondary = Gunmetal,
    tertiary = MidnightGreen,
    onPrimary = Black,
    onSecondary = White,
    onTertiary = CornSilk,
    background = Black,
    surface = RichBlack
)

private val LightColorScheme = lightColorScheme(
    primary = Verdigris,
    secondary = Gunmetal,
    tertiary = MidnightGreen,
    onPrimary = Black,
    onSecondary = White,
    onTertiary = CornSilk,
    background = background,  // Light background
    surface = surface,
)


@Composable
fun ThemeChangeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = CustomTypography,  // Apply custom typography
        content = content
    )
}