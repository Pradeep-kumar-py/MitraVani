package com.example.mitravani.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val DarkColorScheme = darkColorScheme(
    primary = DarkDiyaColors.primary,
    onPrimary = DarkDiyaColors.onPrimary,
    primaryContainer = DarkDiyaColors.primaryContainer,
    onPrimaryContainer = DarkDiyaColors.onPrimary,
    secondary = DarkDiyaColors.primaryContainer,
    tertiary = DarkDiyaColors.avatarSurface,
    background = DarkDiyaColors.background,
    onBackground = DarkDiyaColors.onSurface,
    surface = DarkDiyaColors.surface,
    onSurface = DarkDiyaColors.onSurface,
    surfaceContainer = DarkDiyaColors.surfaceContainer,
    surfaceContainerHigh = DarkDiyaColors.surfaceContainerHigh,
    outline = DarkDiyaColors.outline
)

private val LightColorScheme = lightColorScheme(
    primary = LightDiyaColors.primary,
    onPrimary = LightDiyaColors.onPrimary,
    primaryContainer = LightDiyaColors.primaryContainer,
    onPrimaryContainer = LightDiyaColors.onPrimary,
    secondary = LightDiyaColors.primaryContainer,
    tertiary = LightDiyaColors.avatarSurface,
    background = LightDiyaColors.background,
    onBackground = LightDiyaColors.onSurface,
    surface = LightDiyaColors.surface,
    onSurface = LightDiyaColors.onSurface,
    surfaceContainer = LightDiyaColors.surfaceContainer,
    surfaceContainerHigh = LightDiyaColors.surfaceContainerHigh,
    outline = LightDiyaColors.outline
)

@Composable
fun MitraVaniTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val diyaColors = if (darkTheme) DarkDiyaColors else LightDiyaColors
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    CompositionLocalProvider(LocalDiyaColors provides diyaColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
