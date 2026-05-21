package com.example.mitravani.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBarName(name: String, onClick: () -> Unit ) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .clickable{onClick()}
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(50)
            ),
        contentAlignment = Alignment.Center
    ) {

        // 🔹 Background layer (blur + tint)
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        // 🔹 Foreground text (NOT blurred)
        Text(
            text = name,
            color = Color.White, // ⚠️ use white for contrast
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
        )
    }
}