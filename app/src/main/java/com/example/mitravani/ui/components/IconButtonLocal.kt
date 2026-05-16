package com.example.mitravani.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    iconColor: Color = Color.White,
    backgroundColor: Color = Color.White.copy(alpha = 0.08f),
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(boxSize)
            .clip(CircleShape)
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                CircleShape
            ),
    ) {

        // 🔹 background blur (only this gets blurred)
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(10.dp)
                .background(backgroundColor)
        )

        // 🔹 actual button (NOT blurred)


        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Menu Icon",
                tint = iconColor,
                modifier = Modifier.size(iconSize)
            )
        }
    }
}