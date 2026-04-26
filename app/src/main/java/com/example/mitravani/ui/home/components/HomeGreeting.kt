package com.example.mitravani.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.ui.theme.LocalDiyaColors

@Composable
fun HomeGreeting(
    text: String,
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current

    Text(
        text = text,
        modifier = modifier,
        color = colors.onSurfaceSoft,
        fontSize = 26.sp,
        lineHeight = 36.sp,
        fontFamily = FontFamily.Serif,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun HomeReadyLabel(
    modifier: Modifier = Modifier
) {
    val colors = LocalDiyaColors.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .width(40.dp)
                .height(1.dp)
                .background(colors.separator)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "READY WHEN YOU ARE",
            color = colors.muted,
            fontSize = 11.sp,
            lineHeight = 13.sp,
            letterSpacing = 1.4.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier.width(220.dp),
            textAlign = TextAlign.Center
        )
    }
}
