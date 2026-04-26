package com.example.mitravani.ui.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.mitravani.ui.theme.LocalDiyaColors

@Composable
fun DiyaBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val colors = LocalDiyaColors.current

    Box(modifier = modifier.fillMaxSize()) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawRect(color = colors.background)
            drawRect(
                brush = Brush.radialGradient(
                    colors = listOf(
                        colors.primaryContainer.copy(alpha = if (colors.isDark) 0.15f else 0.22f),
                        colors.background.copy(alpha = if (colors.isDark) 0.82f else 0.74f),
                        colors.background
                    ),
                    center = Offset(size.width / 2f, size.height * 0.35f),
                    radius = 220.dp.toPx()
                )
            )

            val step = 7.dp.toPx()
            val dotSize = 1.dp.toPx()
            var y = 0f
            while (y < size.height) {
                var x = 0f
                while (x < size.width) {
                    val noise = ((x.toInt() * 37 + y.toInt() * 17) % 100) / 100f
                    if (noise > 0.62f) {
                        drawRect(
                            color = colors.grain.copy(
                                alpha = noise * if (colors.isDark) 0.018f else 0.014f
                            ),
                            topLeft = Offset(x, y),
                            size = Size(dotSize, dotSize)
                        )
                    }
                    x += step
                }
                y += step
            }
        }

        content()
    }
}
