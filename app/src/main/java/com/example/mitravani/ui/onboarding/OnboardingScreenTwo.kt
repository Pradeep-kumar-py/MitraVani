package com.example.mitravani.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R

@Composable
fun OnboardingScreenTwo() {

    var userNameState = rememberTextFieldState()

    Surface(
            modifier = Modifier.fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF151919),
                            Color(0xFF232828),
                            Color(0xFF151919)
                        )
                    )
                ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "What should I",
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Text(
                text = "call you?",
                fontSize = 40.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(26.dp))

            OutlinedTextField(
                state = userNameState,
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.fillMaxWidth(0.8f).clip(RoundedCornerShape(30.dp)).background(Color(0xFF12C3131)),

                placeholder = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Enter your name",
                            color = Color.Gray
                        )
                     }

                },
                colors = OutlinedTextFieldDefaults.colors(

                    focusedBorderColor = Color(0xFFADCDCC),

                    unfocusedBorderColor = Color.Gray.copy(alpha = 0.4f),

                    cursorColor = Color(0xFFADCDCC),

                    focusedTextColor = Color.White,

                    unfocusedTextColor = Color.White

                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "This helps me talk to you better",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.8.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            IconButton(
                modifier = Modifier.size(60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .border(BorderStroke(0.4.dp, Color(0xFF3D4141)), RoundedCornerShape(30.dp))

                    .background(Color(0xFF12C3131)),
                onClick = {}
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_forward),
                    contentDescription = "Next",
                    tint = Color(0xFFADCDCC)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenTwoPreview() {
    OnboardingScreenTwo()
}