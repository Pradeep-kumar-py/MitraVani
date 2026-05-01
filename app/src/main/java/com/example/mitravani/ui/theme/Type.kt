package com.example.mitravani.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp

// ─── Font Families ────────────────────────────────────────────────────────────
// Using system default for now.
// Replace FontFamily.Default with PlusJakartaSans / Manrope
// once res/font/ files are set up.

val PlusJakartaSans = FontFamily.Default
val Manrope         = FontFamily.Default

// ─── Custom Type Scale ────────────────────────────────────────────────────────
object MitravaniType {

    /** 48sp / SemiBold / –0.02em — hero headlines */
    val Display = TextStyle(
        fontFamily    = PlusJakartaSans,
        fontWeight    = FontWeight.SemiBold,
        fontSize      = 48.sp,
        lineHeight    = (48 * 1.2).sp,
        letterSpacing = (-0.02).em,
    )

    /** 32sp / SemiBold — screen titles */
    val H1 = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.SemiBold,
        fontSize   = 32.sp,
        lineHeight = (32 * 1.3).sp,
    )

    /** 24sp / Medium — section headings */
    val H2 = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Medium,
        fontSize   = 24.sp,
        lineHeight = (24 * 1.4).sp,
    )

    /** 18sp / Regular — comfortable reading */
    val BodyLg = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize   = 18.sp,
        lineHeight = (18 * 1.6).sp,
    )

    /** 16sp / Regular — standard body */
    val BodyMd = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize   = 16.sp,
        lineHeight = (16 * 1.6).sp,
    )

    /** 14sp / SemiBold / +0.05em — labels, buttons */
    val Label = TextStyle(
        fontFamily    = Manrope,
        fontWeight    = FontWeight.SemiBold,
        fontSize      = 14.sp,
        lineHeight    = (14 * 1.4).sp,
        letterSpacing = 0.05.em,
    )
}

// ─── Material3 Typography ─────────────────────────────────────────────────────
val MitravaniTypography = Typography(
    displayLarge  = MitravaniType.Display,
    displayMedium = MitravaniType.Display.copy(fontSize = 40.sp),
    displaySmall  = MitravaniType.H1,

    headlineLarge  = MitravaniType.H1,
    headlineMedium = MitravaniType.H2,
    headlineSmall  = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Medium,
        fontSize   = 20.sp,
        lineHeight = (20 * 1.4).sp,
    ),

    titleLarge  = MitravaniType.H2,
    titleMedium = MitravaniType.BodyLg.copy(fontWeight = FontWeight.Medium),
    titleSmall  = MitravaniType.BodyMd.copy(fontWeight = FontWeight.Medium),

    bodyLarge  = MitravaniType.BodyLg,
    bodyMedium = MitravaniType.BodyMd,
    bodySmall  = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Normal,
        fontSize   = 14.sp,
        lineHeight = (14 * 1.6).sp,
    ),

    labelLarge  = MitravaniType.Label,
    labelMedium = MitravaniType.Label.copy(fontSize = 12.sp),
    labelSmall  = MitravaniType.Label.copy(fontSize = 11.sp),
)