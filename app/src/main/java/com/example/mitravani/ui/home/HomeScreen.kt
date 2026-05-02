package com.example.mitravani.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mitravani.R
import com.example.mitravani.ui.components.IconButtonLocal
import com.example.mitravani.ui.components.TopBarName


@Composable
fun HomeScreen() {

    var messageInputState = rememberTextFieldState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121A1A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {

                IconButtonLocal(
                    onClick = { /* Handle menu click */ },
                    icon = R.drawable.ic_menu,
                )

                TopBarName(name = "MitraVani")

                IconButtonLocal(
                    onClick = { /* Handle menu click */ },
                    icon = R.drawable.ic_profile,
                    iconSize = 40.dp,
                )

            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(40) { index ->
                    if (index % 2 == 0) {
                        MitraVaniMessageBubble(message = "Hello! This is a message from MitraVani. How can I assist you today?")
                    } else {
                        UserMessageBubble(message = "Hi MitraVani! I have a question about my account.")
                    }
                }
            }

            BottomBar(messageInputState = messageInputState)
        }
    }

}




@Composable
fun BottomBar(messageInputState: TextFieldState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(50))
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(50)
            )
    ) {

        // 🔹 Glass background
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 🎤 Left icon (circle background)
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.4f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_graphic_eq),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }

            // ✏️ Text input
            TextField(
                state = messageInputState,
                placeholder = {
                    Text(
                        "Your message",
                        color = Color.White.copy(alpha = 0.6f)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
            )

            // ➕ Right icon
            Icon(
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}


@Composable
fun MitraVaniMessageBubble(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Bottom
    ) {

        // 🤖 Bot avatar
        Box(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape)
                .background(Color(0xFF6EC6B8)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_graphic_eq),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // 💬 Glass bubble
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.2f),
                    RoundedCornerShape(20.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .blur(20.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )

            Text(
                text = message,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .widthIn(max = 260.dp)
            )
        }
    }
}

@Composable
fun UserMessageBubble(message: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom
    ) {

        // 💬 Glass bubble
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.2f),
                    RoundedCornerShape(20.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .blur(20.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )

            Text(
                text = message,
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .widthIn(max = 260.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}