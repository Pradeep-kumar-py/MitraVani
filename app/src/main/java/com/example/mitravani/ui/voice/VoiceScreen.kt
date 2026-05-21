package com.example.mitravani.ui.voice

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.ui.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R
import com.example.mitravani.ui.components.IconButtonLocal
import com.example.mitravani.ui.components.TopBarName

@Composable
fun VoiceScreen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF121A1A)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    icon = R.drawable.ic_arrow_back,
                )

                TopBarName("Voice", onClick = {})

                IconButtonLocal(
                    onClick = { /* Handle menu click */ },
                    icon = R.drawable.ic_profile,
                    iconSize = 40.dp,
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        painter = painterResource(id = R.drawable.ic_volume_up),
                        contentDescription = "Voice Wave",
                        tint = Color.White.copy(alpha = 0.7f),
                        modifier = Modifier.size(200.dp)
                    )
                }

                Text(
                    text = "Mitravani",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (1.5).sp
                )
                Text(
                    text = "Listening...",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 20.sp,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))

            BottomCallBar()

            Spacer(modifier = Modifier.height(36.dp))

        }
    }
}

@Composable
fun BottomCallBar(){
    Box(
        modifier = Modifier
            .fillMaxWidth(0.85f)
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
                .padding(horizontal = 12.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            IconButtonLocal(
                onClick = { /* Handle mic click */ },
                icon = R.drawable.ic_volume_up,
                boxSize = 60.dp,
                iconSize = 30.dp
            )

            IconButtonLocal(
                onClick = { /* Handle mic click */ },
                icon = R.drawable.ic_mic,
                boxSize = 60.dp,
                iconSize = 30.dp
            )
            IconButtonLocal(
                onClick = { /* Handle mic click */ },
                icon = R.drawable.ic_close,
                boxSize = 60.dp,
                iconSize = 40.dp,
                backgroundColor = Color.Red
            )

        }
    }
}


@Preview(showBackground = true)
@Composable
fun VoiceScreenPreview() {
    VoiceScreen()
}