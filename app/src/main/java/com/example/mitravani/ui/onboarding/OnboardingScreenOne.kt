package com.example.mitravani.ui.onboarding

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R
import com.example.mitravani.navigation.LocalNavigator
import com.example.mitravani.navigation.Screen

@Composable
fun OnboardingScreenOne() {
    val navigator = LocalNavigator.current

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF101E1E),
                        Color(0xFF084949),
                        Color(0xFF101E1E)
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
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Meet", fontSize = 40.sp, fontWeight = FontWeight.Medium, color = Color.White)
                Text("Mitravani", fontSize = 40.sp, fontWeight = FontWeight.Medium, color = Color.White)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "A friend who listens to you",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                )
            }

            OutlinedButton(
                onClick = { navigator.navigate(Screen.OnboardingScreenTwo) },
                modifier = Modifier.fillMaxWidth(0.8f).padding(bottom = 60.dp).height(60.dp),
                border = BorderStroke(0.8.dp, Color(0xFF305656)),
            ) {
                Text("Start", fontSize = 22.sp, color = Color(0xFFADCDCC), letterSpacing = 1.sp)
                Spacer(modifier = Modifier.width(6.dp))
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_forward),
                    contentDescription = null,
                    tint = Color(0xFFADCDCC),
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}