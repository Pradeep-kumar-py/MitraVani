package com.example.mitravani.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

// ─── Material3 Color Scheme ───────────────────────────────────────────────────
// Wired from DarkMitravaniColors so every Material component uses the palette.
private val MitravaniDarkColorScheme = darkColorScheme(
    primary                = DarkMitravaniColors.primary,
    onPrimary              = DarkMitravaniColors.onPrimary,
    primaryContainer       = DarkMitravaniColors.primaryContainer,
    onPrimaryContainer     = DarkMitravaniColors.onPrimaryContainer,
    inversePrimary         = DarkMitravaniColors.inversePrimary,

    secondary              = DarkMitravaniColors.secondary,
    onSecondary            = DarkMitravaniColors.onSecondary,
    secondaryContainer     = DarkMitravaniColors.secondaryContainer,
    onSecondaryContainer   = DarkMitravaniColors.onSecondaryContainer,

    tertiary               = DarkMitravaniColors.tertiary,
    onTertiary             = DarkMitravaniColors.onTertiary,
    tertiaryContainer      = DarkMitravaniColors.tertiaryContainer,
    onTertiaryContainer    = DarkMitravaniColors.onTertiaryContainer,

    background             = DarkMitravaniColors.background,
    onBackground           = DarkMitravaniColors.onSurface,
    surface                = DarkMitravaniColors.surface,
    onSurface              = DarkMitravaniColors.onSurface,
    onSurfaceVariant       = DarkMitravaniColors.onSurfaceVariant,
    surfaceVariant         = SurfaceVariant,
    inverseSurface         = DarkMitravaniColors.inverseSurface,
    inverseOnSurface       = DarkMitravaniColors.inverseOnSurface,
    surfaceContainer       = DarkMitravaniColors.surfaceContainer,
    surfaceContainerHigh   = DarkMitravaniColors.surfaceContainerHigh,
    surfaceContainerHighest= DarkMitravaniColors.surfaceContainerHighest,
    surfaceContainerLow    = DarkMitravaniColors.surfaceContainerLow,

    outline                = DarkMitravaniColors.outline,
    outlineVariant         = DarkMitravaniColors.outlineVariant,

    error                  = DarkMitravaniColors.error,
    onError                = DarkMitravaniColors.onError,
    errorContainer         = DarkMitravaniColors.errorContainer,
    onErrorContainer       = DarkMitravaniColors.onErrorContainer,
)

// ─── Theme Composable ─────────────────────────────────────────────────────────
@Composable
fun MitraVaniTheme(
    // Currently only a dark theme is defined in DESIGN.md.
    // Pass darkTheme = false once a light palette is added.
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = DarkMitravaniColors  // swap to a LightMitravaniColors when ready

    CompositionLocalProvider(LocalMitravaniColors provides colors) {
        MaterialTheme(
            colorScheme = MitravaniDarkColorScheme,
            typography  = MitravaniTypography,
            content     = content
        )
    }
}

// ─── Convenience Accessor ─────────────────────────────────────────────────────
// Usage: val teal = MitraVaniTheme.colors.primary
object MitraVaniTheme {
    val colors: MitravaniColors
        @Composable get() = LocalMitravaniColors.current
}