package com.example.mitravani.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconButtonLocal(
    onClick: () -> Unit,
    icon: Int,
    iconSize: Dp = 30.dp,
    boxSize: Dp = 48.dp,
    backgroundColor: Color = Color.White.copy(alpha = 0.08f)
) {
    Box(
        modifier = Modifier
            .size(boxSize)
            .clip(CircleShape)
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                CircleShape
            )
    ) {

        // 🔹 background blur (only this gets blurred)
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(10.dp)
                .background(backgroundColor)
        )

        // 🔹 actual button (NOT blurred)
        IconButton(
            onClick = onClick,
            modifier = Modifier.matchParentSize()
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Menu Icon",
                tint = Color.White,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}