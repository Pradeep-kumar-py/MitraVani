package com.example.mitravani.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.ui.theme.LocalDiyaColors

@Composable
fun HomeTopBar(
    companionInitial: String,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(colors.avatarSurface),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = companionInitial,
                color = colors.primaryContainer,
                fontSize = 25.sp,
                lineHeight = 25.sp,
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center
            )
        }

        Box(modifier = Modifier.weight(1f))

        IconButton(onClick = onSettingsClick) {
            Text(
                text = "⚙",
                color = colors.muted.copy(alpha = 0.95f),
                fontSize = 32.sp,
                lineHeight = 32.sp
            )
        }
    }
}
