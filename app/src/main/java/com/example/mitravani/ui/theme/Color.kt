package com.example.mitravani.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class DiyaColors(
    val background: Color,
    val surface: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val onSurface: Color,
    val onSurfaceSoft: Color,
    val muted: Color,
    val outline: Color,
    val primary: Color,
    val primaryContainer: Color,
    val primaryContainerDeep: Color,
    val onPrimary: Color,
    val avatarSurface: Color,
    val orbCore: Color,
    val separator: Color,
    val grain: Color,
    val isDark: Boolean
)

val DarkDiyaColors = DiyaColors(
    background = Color(0xFF080608),
    surface = Color(0xFF131411),
    surfaceContainer = Color(0xFF110E14),
    surfaceContainerHigh = Color(0xFF2A2A27),
    onSurface = Color(0xFFE5E2DD),
    onSurfaceSoft = Color(0xFFF0EDE8),
    muted = Color(0xFF4A4448),
    outline = Color(0xFF2A2232),
    primary = Color(0xFFFFB68B),
    primaryContainer = Color(0xFFD47A3E),
    primaryContainerDeep = Color(0xFF7A4018),
    onPrimary = Color(0xFF522300),
    avatarSurface = Color(0xFF1A1520),
    orbCore = Color(0xFFFFF4E0),
    separator = Color(0xFF1E1A1C),
    grain = Color.White,
    isDark = true
)

val LightDiyaColors = DiyaColors(
    background = Color(0xFFFFF7EF),
    surface = Color(0xFFFFF3E7),
    surfaceContainer = Color(0xFFFFEBDD),
    surfaceContainerHigh = Color(0xFFF2D9C6),
    onSurface = Color(0xFF2E211A),
    onSurfaceSoft = Color(0xFF3B271E),
    muted = Color(0xFF8E7466),
    outline = Color(0xFFE6CBB8),
    primary = Color(0xFF8E4512),
    primaryContainer = Color(0xFFC46C2C),
    primaryContainerDeep = Color(0xFF8E4512),
    onPrimary = Color(0xFFFFF6EC),
    avatarSurface = Color(0xFFF2E4DA),
    orbCore = Color(0xFFFFF0D8),
    separator = Color(0xFFE6D1C0),
    grain = Color(0xFF3B271E),
    isDark = false
)

val LocalDiyaColors = staticCompositionLocalOf { DarkDiyaColors }
