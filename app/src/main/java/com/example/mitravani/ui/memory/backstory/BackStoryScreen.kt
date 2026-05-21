package com.example.mitravani.ui.memory.backstory

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.ui.components.IconButtonLocal
import com.example.mitravani.R
@Composable
fun BackStoryScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121A1A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButtonLocal(
                    onClick = { },
                    icon = R.drawable.ic_arrow_back,
                    iconSize = 24.dp,
                    boxSize = 36.dp
                )

                Text(
                    text = "BackStory",
                    color = Color.White,
                    fontSize = 24.sp
                )

                Spacer(modifier = Modifier.width(20.dp))
            }
            Spacer(modifier = Modifier.height(20.dp))

            MemoryInputCard()
            Spacer(modifier = Modifier.height(20.dp))
            MemoryCardSaveButton()

        }
    }
}


@Composable
fun MemoryInputCard() {
    var text by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )

        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(0.88f)
        ) {

            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = {
                    Text("Write your backstory...", color = Color.White.copy(0.8f))
                },
//                textStyle = LocalTextStyle.current.copy(
//
//                    fontSize = 18.sp
//
//                ),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    cursorColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White
                ),
                maxLines = Int.MAX_VALUE
            )
        }

    }
}

@Composable
fun MemoryCardSaveButton() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth(.9f)
            .clickable {  }
            .border(
                1.dp,
                Color.White.copy(alpha = 0.2f),
                RoundedCornerShape(30.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .matchParentSize()
                .blur(20.dp)
                .background(Color.White.copy(alpha = 0.08f))
        )
            Text(
                "Save",
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier.padding(vertical = 14.dp)
            )
    }
}


@Preview(showBackground = true)
@Composable
fun BackStoryScreenPreview() {
    BackStoryScreen()
}

