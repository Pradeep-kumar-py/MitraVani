package com.example.mitravani.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// ─── Raw Palette ──────────────────────────────────────────────────────────────
// Primary / Teal family
val Teal10  = Color(0xFF002020)
val Teal20  = Color(0xFF0F2E2E)
val Teal30  = Color(0xFF173535)
val Teal40  = Color(0xFF2E4C4C)
val Teal60  = Color(0xFF466463)
val Teal70  = Color(0xFF789696)
val Teal80  = Color(0xFFADCDCC)
val Teal90  = Color(0xFFC8E9E8)

// Secondary / Muted Teal
val SecTeal20 = Color(0xFF131D1D)
val SecTeal30 = Color(0xFF273232)
val SecTeal40 = Color(0xFF3E4949)
val SecTeal50 = Color(0xFF404B4B)
val SecTeal80 = Color(0xFFBDC9C8)
val SecTeal90 = Color(0xFFD9E5E4)

// Tertiary / Warm Terracotta
val Terra20 = Color(0xFF2D150A)
val Terra30 = Color(0xFF3E2317)
val Terra40 = Color(0xFF46291D)
val Terra50 = Color(0xFF5F3F32)
val Terra80 = Color(0xFFEABDAB)
val Terra90 = Color(0xFFFFDBCD)

// Neutral / Surface
val Surface    = Color(0xFF121414)
val SurfaceDim = Color(0xFF121414)
val SurfaceBrt = Color(0xFF383939)
val SurfCtnLowest  = Color(0xFF0D0E0E)
val SurfCtnLow     = Color(0xFF1A1C1C)
val SurfCtn        = Color(0xFF1E2020)
val SurfCtnHigh    = Color(0xFF292A2A)
val SurfCtnHighest = Color(0xFF343535)
val OnSurface      = Color(0xFFE3E2E2)
val OnSurfaceVar   = Color(0xFFC1C8C7)
val InverseSurface = Color(0xFFE3E2E2)
val InverseOnSurf  = Color(0xFF2F3130)
val SurfaceVariant = Color(0xFF343535)

// Outline
val Outline    = Color(0xFF8B9292)
val OutlineVar = Color(0xFF414848)

// Error
val Error          = Color(0xFFFFB4AB)
val OnError        = Color(0xFF690005)
val ErrorContainer = Color(0xFF93000A)
val OnErrorCtn     = Color(0xFFFFDAD6)

// ─── Semantic Token Wrapper ────────────────────────────────────────────────────
@Immutable
data class MitravaniColors(
    val background: Color,
    val surface: Color,
    val surfaceDim: Color,
    val surfaceBright: Color,
    val surfaceContainerLowest: Color,
    val surfaceContainerLow: Color,
    val surfaceContainer: Color,
    val surfaceContainerHigh: Color,
    val surfaceContainerHighest: Color,
    val onSurface: Color,
    val onSurfaceVariant: Color,
    val inverseSurface: Color,
    val inverseOnSurface: Color,
    val outline: Color,
    val outlineVariant: Color,
    // Primary
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val inversePrimary: Color,
    val primaryFixed: Color,
    val primaryFixedDim: Color,
    val onPrimaryFixed: Color,
    val onPrimaryFixedVariant: Color,
    // Secondary
    val secondary: Color,
    val onSecondary: Color,
    val secondaryContainer: Color,
    val onSecondaryContainer: Color,
    val secondaryFixed: Color,
    val secondaryFixedDim: Color,
    val onSecondaryFixed: Color,
    val onSecondaryFixedVariant: Color,
    // Tertiary
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer: Color,
    val tertiaryFixed: Color,
    val tertiaryFixedDim: Color,
    val onTertiaryFixed: Color,
    val onTertiaryFixedVariant: Color,
    // Error
    val error: Color,
    val onError: Color,
    val errorContainer: Color,
    val onErrorContainer: Color,
    // Glassmorphism helpers
    val glassfill: Color,
    val glassBorder: Color,
    val orbColor1: Color,
    val orbColor2: Color,
    val isDark: Boolean
)

val DarkMitravaniColors = MitravaniColors(
    background                = Surface,
    surface                   = Surface,
    surfaceDim                = SurfaceDim,
    surfaceBright             = SurfaceBrt,
    surfaceContainerLowest    = SurfCtnLowest,
    surfaceContainerLow       = SurfCtnLow,
    surfaceContainer          = SurfCtn,
    surfaceContainerHigh      = SurfCtnHigh,
    surfaceContainerHighest   = SurfCtnHighest,
    onSurface                 = OnSurface,
    onSurfaceVariant          = OnSurfaceVar,
    inverseSurface            = InverseSurface,
    inverseOnSurface          = InverseOnSurf,
    outline                   = Outline,
    outlineVariant            = OutlineVar,
    primary                   = Teal80,
    onPrimary                 = Teal30,
    primaryContainer          = Teal20,
    onPrimaryContainer        = Teal70,
    inversePrimary            = Teal60,
    primaryFixed              = Teal90,
    primaryFixedDim           = Teal80,
    onPrimaryFixed            = Teal10,
    onPrimaryFixedVariant     = Teal40,
    secondary                 = SecTeal80,
    onSecondary               = SecTeal30,
    secondaryContainer        = SecTeal50,
    onSecondaryContainer      = SecTeal80,
    secondaryFixed            = SecTeal90,
    secondaryFixedDim         = SecTeal80,
    onSecondaryFixed          = SecTeal20,
    onSecondaryFixedVariant   = SecTeal40,
    tertiary                  = Terra80,
    onTertiary                = Terra40,
    tertiaryContainer         = Terra30,
    onTertiaryContainer       = Terra50,
    tertiaryFixed             = Terra90,
    tertiaryFixedDim          = Terra80,
    onTertiaryFixed           = Terra20,
    onTertiaryFixedVariant    = Terra50,
    error                     = Error,
    onError                   = OnError,
    errorContainer            = ErrorContainer,
    onErrorContainer          = OnErrorCtn,
    glassfill                 = Color(0x14FFFFFF), // rgba(255,255,255,0.08)
    glassBorder               = Color(0x26FFFFFF), // rgba(255,255,255,0.15)
    orbColor1                 = Teal80,
    orbColor2                 = SecTeal80,
    isDark                    = true
)

// Convenience alias so existing call-sites compile
val LocalMitravaniColors = staticCompositionLocalOf { DarkMitravaniColors }