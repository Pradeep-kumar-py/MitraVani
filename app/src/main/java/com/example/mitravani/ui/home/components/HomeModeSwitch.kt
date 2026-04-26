package com.example.mitravani.ui.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.ui.theme.LocalDiyaColors

enum class HomeMode {
    Voice,
    Text
}

@Composable
fun HomeModeSwitch(
    selectedMode: HomeMode,
    onModeSelected: (HomeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .background(colors.surfaceContainer)
            .border(
                border = BorderStroke(1.dp, colors.outline),
                shape = RoundedCornerShape(999.dp)
            )
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        HomeModeTab(
            text = "Voice",
            selected = selectedMode == HomeMode.Voice,
            onClick = { onModeSelected(HomeMode.Voice) }
        )
        HomeModeTab(
            text = "Text",
            selected = selectedMode == HomeMode.Text,
            onClick = { onModeSelected(HomeMode.Text) }
        )
    }
}

@Composable
private fun HomeModeTab(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current

    Column(
        modifier = modifier
            .clip(RoundedCornerShape(999.dp))
            .clickable(onClick = onClick)
            .width(78.dp)
            .height(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = text,
            color = if (selected) colors.primaryContainer else colors.muted,
            fontSize = 17.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .width(18.dp)
                .height(2.dp)
                .background(
                    color = if (selected) colors.primaryContainer else colors.surfaceContainer,
                    shape = RoundedCornerShape(999.dp)
                )
        )
    }
}
