package com.example.mitravani.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mitravani.ui.theme.LocalDiyaColors

@Composable
fun HearthOrb(
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current
    val glowStrength = if (colors.isDark) 1f else 0.72f

    Box(
        modifier = modifier
            .size(width = 200.dp, height = 210.dp)
            .drawBehind {
                val center = Offset(size.width / 2f, size.height / 2f)
                drawRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            colors.primaryContainer.copy(alpha = 0.05f * glowStrength),
                            colors.primaryContainer.copy(alpha = 0.08f * glowStrength),
                            Color.Transparent
                        )
                    ),
                    topLeft = Offset(size.width * 0.18f, 0f),
                    size = Size(size.width * 0.64f, size.height)
                )
                drawCircle(
                    color = colors.primaryContainer.copy(alpha = 0.10f * glowStrength),
                    radius = 150.dp.toPx(),
                    center = center
                )
                drawCircle(
                    color = colors.primaryContainer.copy(alpha = 0.20f * glowStrength),
                    radius = 100.dp.toPx(),
                    center = center
                )
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(
                            colors.primaryContainer.copy(alpha = 0.78f * glowStrength),
                            colors.primaryContainer.copy(alpha = 0.36f * glowStrength),
                            colors.background.copy(alpha = 0f)
                        ),
                        center = center,
                        radius = 88.dp.toPx()
                    ),
                    radius = 88.dp.toPx(),
                    center = center
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(colors.orbCore, CircleShape)
        )
    }
}
