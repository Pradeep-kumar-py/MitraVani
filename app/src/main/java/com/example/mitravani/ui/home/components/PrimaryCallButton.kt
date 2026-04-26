package com.example.mitravani.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.ui.theme.LocalDiyaColors

@Composable
fun PrimaryCallButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current

    Box(
        modifier = modifier
            .width(170.dp)
            .height(70.dp)
            .drawBehind {
                val corner = CornerRadius(999.dp.toPx(), 999.dp.toPx())
                drawRoundRect(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colors.primaryContainer.copy(alpha = 0.24f),
                            colors.primaryContainer.copy(alpha = 0.12f),
                            Color.Transparent
                        )
                    ),
                    topLeft = Offset(0f, 0f),
                    size = Size(size.width, size.height),
                    cornerRadius = corner
                )

            },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(154.dp)
                .height(56.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colors.primaryContainer,
                            colors.primaryContainerDeep
                        )
                    ),
                    shape = RoundedCornerShape(999.dp)
                )
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = colors.onPrimary,
                fontSize = 17.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}
