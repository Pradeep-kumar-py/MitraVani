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
fun OnboardingScreenThree() {
    val navigator = LocalNavigator.current
    val viewModel: OnboardingViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsState()

    Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFF191B1B)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 34.dp)
                .clip(RoundedCornerShape(36.dp))
                .background(Color(0xFF232727), shape = RoundedCornerShape(36.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_spa),
                contentDescription = null,
                tint = Color(0xFF84B4B4),
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .border(1.dp, Color(0xFF3C4A4A), RoundedCornerShape(50.dp))
                    .background(Color(0xFF1E2929))
                    .padding(18.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("What would you", fontSize = 32.sp, fontWeight = FontWeight.Medium, color = Color.White)
            Text("like to call me?", fontSize = 32.sp, fontWeight = FontWeight.Medium, color = Color.White)

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                value = uiState.companionName,
                onValueChange = viewModel::onCompanionNameChange,
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier.fillMaxWidth(0.8f).clip(RoundedCornerShape(30.dp)),
                singleLine = true,
                placeholder = {
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        Text("Enter a name", color = Color.Gray)
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

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                "Or you can call me Mitravani 💚",
                modifier = Modifier.fillMaxWidth(0.75f),
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(30.dp))

            // — Personality —
            Text(
                "Personality",
                modifier = Modifier.fillMaxWidth(0.75f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            val personalities = listOf("Romantic", "Friendly", "Playful", "Supportive")
            personalities.chunked(2).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(0.75f),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { option ->
                        SelectableButton(
                            text = option,
                            selected = uiState.personality == option,
                            onClick = { viewModel.onPersonalityChange(option) },
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }

            Spacer(modifier = Modifier.height(20.dp))

            // — Gender —
            Text(
                "Gender",
                modifier = Modifier.fillMaxWidth(0.75f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.75f),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                listOf("Male", "Female").forEach { option ->
                    SelectableButton(
                        text = option,
                        selected = uiState.gender == option,
                        onClick = { viewModel.onGenderChange(option) },
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // — Continue button —
            OutlinedButton(
                onClick = {
                    viewModel.saveProfile {
                        navigator.clearAndNavigate(Screen.Home)
                    }
                },
                enabled = !uiState.isSaving,
                modifier = Modifier.fillMaxWidth(0.75f).height(50.dp),
                border = BorderStroke(0.8.dp, Color(0xFF305656)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFADCDCC))
            ) {
                if (uiState.isSaving) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        color = Color(0xFFADCDCC),
                        strokeWidth = 2.dp
                    )
                } else {
                    Text("Let's go")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_forward),
                        contentDescription = null,
                        tint = Color(0xFFADCDCC),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}

// Reusable selected/unselected button
@Composable
fun SelectableButton(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.height(46.dp),
        border = BorderStroke(
            width = if (selected) 1.5.dp else 0.8.dp,
            color = if (selected) Color(0xFFADCDCC) else Color(0xFF305656)
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = if (selected) Color(0xFF1E3333) else Color.Transparent,
            contentColor = if (selected) Color(0xFFADCDCC) else Color(0xFF6B8888)
        )
    ) {
        Text(text, fontSize = 13.sp)
    }
}