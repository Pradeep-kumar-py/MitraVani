package com.example.mitravani.ui.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R
import com.example.mitravani.domain.model.Sender
import com.example.mitravani.ui.components.IconButtonLocal
import com.example.mitravani.ui.components.TopBarName
import org.koin.androidx.compose.koinViewModel


@Composable
fun HomeScreen() {

    val viewModel: HomeViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(uiState.messages.size, uiState.streamingText) {
        if (uiState.messages.isNotEmpty()) {
            listState.animateScrollToItem(
                uiState.messages.size + if (uiState.isStreaming) 1 else 0
            )
        }
    }

    // ✅ Simple String state — no TextFieldState
    var messageInputState by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121A1A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .background(Color.Transparent)
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
                    onClick = { },
                    icon = R.drawable.ic_menu,
                    iconSize = 24.dp,
                    boxSize = 36.dp
                )
                TopBarName(name = "MitraVani")
                IconButtonLocal(
                    onClick = { },
                    icon = R.drawable.ic_profile,
                    iconSize = 30.dp,
                    boxSize = 36.dp
                )
            }

            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp),
                reverseLayout = false  // keep false, messages go top to bottom

            ) {
                items(uiState.messages, key = { it.id }) { message ->
                    if (message.sender == Sender.MITRAVANI) {
                        MitraVaniMessageBubble(message.text)
                    } else {
                        UserMessageBubble(message.text)
                    }
                }
                if (uiState.isStreaming) {
                    item {
                        MitraVaniMessageBubble(
                            message = uiState.streamingText.ifBlank { "..." }
                        )
                    }
                }
            }

            BottomBar(
                messageInputState = uiState.inputText,
                onValueChange = viewModel::onInputChange ,
                onSend = { text ->
                    viewModel.sendMessage(text)
                }
            )
        }
    }
}


@Composable
fun BottomBar(
    messageInputState: String,          // ✅ plain String
    onValueChange: (String) -> Unit,    // ✅ plain callback
    onSend: (String) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .background(Color.Transparent),
        verticalAlignment = Alignment.Bottom
    ) {
        IconButtonLocal(
            onClick = { },
            icon = R.drawable.ic_graphic_eq,
            boxSize = 36.dp,
            iconSize = 26.dp
        )

        Spacer(modifier = Modifier.width(8.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(20.dp))
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.2f),
                    RoundedCornerShape(20.dp)
                )
        ) {
            // Glass effect
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .blur(20.dp)
                    .background(Color.White.copy(alpha = 0.08f))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                // ✅ Standard BasicTextField with value/onValueChange
                BasicTextField(
                    value = messageInputState,
                    onValueChange = onValueChange,
                    modifier = Modifier.weight(1f),
                    textStyle = TextStyle(color = Color.White, fontSize = 16.sp, lineHeight = 18.sp),
                    cursorBrush = SolidColor(Color.White),
                    maxLines = 5,
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp, vertical = 10.dp)
                        ) {
                            if (messageInputState.isEmpty()) {
                                Text(
                                    "Message",
                                    color = Color.White.copy(alpha = 0.4f),
                                    fontSize = 16.sp,
                                    lineHeight = 18.sp
                                )
                            }
                            innerTextField()
                        }
                    }
                )

                Spacer(modifier = Modifier.width(2.dp))

                // ✅ Use plain String's .isNotEmpty()
                AnimatedContent(
                    targetState = messageInputState.isNotEmpty(),
                    label = "send_button_animation",
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 4.dp)
                ) { hasText ->
                    IconButtonLocal(
                        onClick = {
                            if (hasText) {
                                onSend(messageInputState) // ✅ pass plain String
                            }
                        },
                        icon = if (hasText) R.drawable.ic_arrow_upward else R.drawable.ic_add,
                        boxSize = 32.dp,
                        iconSize = 20.dp,
                        backgroundColor = if (hasText) Color.White else Color.Transparent,
                        iconColor = if (hasText) Color.Black else Color.White,
                    )
                }
            }
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

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(20.dp))
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
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
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
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .border(1.dp, Color.White.copy(alpha = 0.2f), RoundedCornerShape(20.dp))
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
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 6.dp)
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