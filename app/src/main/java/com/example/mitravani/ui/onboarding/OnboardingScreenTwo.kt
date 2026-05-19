package com.example.mitravani.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R
import com.example.mitravani.navigation.LocalNavigator
import com.example.mitravani.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun OnboardingScreenTwo() {
    val navigator = LocalNavigator.current
    val viewModel: OnboardingViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()

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
            modifier = Modifier.fillMaxSize().padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("What should I", fontSize = 40.sp, fontWeight = FontWeight.Medium, color = Color.White)
            Text("call you?", fontSize = 40.sp, fontWeight = FontWeight.Medium, color = Color.White)

            Spacer(modifier = Modifier.height(26.dp))

            OutlinedTextField(
                value = uiState.userName,
                onValueChange = viewModel::onUserNameChange,
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(30.dp)),
                singleLine = true,
                placeholder = {
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Enter your name", color = Color.Gray)
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

            Spacer(modifier = Modifier.height(8.dp))

            // Show error if name is blank on continue
            uiState.error?.let { error ->
                Text(
                    text = error,
                    color = Color(0xFFFF6B6B),
                    fontSize = 13.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "This helps me talk to you better",
                fontSize = 14.sp,
                letterSpacing = 0.8.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(40.dp))

            IconButton(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .border(BorderStroke(0.4.dp, Color(0xFF3D4141)), RoundedCornerShape(30.dp)),
                onClick = {
                    if (uiState.userName.isNotBlank()) {
                        viewModel.clearError()
                        navigator.navigate(Screen.OnboardingScreenThree)
                    } else {
                        viewModel.onUserNameChange("") // triggers error display
                    }
                }
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