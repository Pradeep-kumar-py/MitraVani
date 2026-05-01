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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mitravani.R


@Composable
fun OnboardingScreenThree() {

    val mitravaniNameState = rememberTextFieldState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF191B1B)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 34.dp)
                .clip(RoundedCornerShape(36.dp))
                .background(Color(0xFF232727), shape = RoundedCornerShape(36.dp)),
//            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Icon(
                painter = painterResource(id = R.drawable.ic_spa),
                contentDescription = "Spa Icon",
                tint = Color(0xFF84B4B4),
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .border(1.dp, Color(0xFF3C4A4A), shape = RoundedCornerShape(50.dp))
                    .background(Color(0xFF1E2929), shape = RoundedCornerShape(50.dp))
                    .padding(18.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "What would you",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
            )
            Text(
                text = "like to call me?",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
            )

            Spacer(modifier = Modifier.height(30.dp))

            OutlinedTextField(
                state = mitravaniNameState,
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color(0xFF12C3131)),

                placeholder = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Enter a name",
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

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Or you can call me Mitravani 💚",
                modifier = Modifier.fillMaxWidth(0.75f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.8.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Personality",
                modifier = Modifier.fillMaxWidth(0.75f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.8.sp,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.75f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutLinedButton("Romantic", onClick = { /* TODO: Set personality to Friendly */ }, modifier = Modifier.weight(1f))

                OutLinedButton("Friendly", onClick = { /* TODO: Set personality to Friendly */ }, modifier = Modifier.weight(1f))


            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(0.75f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutLinedButton("Playful", onClick = { /* TODO: Set personality to Friendly */ }, modifier = Modifier.weight(1f))

                OutLinedButton("Supportive", onClick = { /* TODO: Set personality to Friendly */ }, modifier = Modifier.weight(1f))


            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Gender",
                modifier = Modifier.fillMaxWidth(0.75f),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.8.sp,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))


            Row(
                modifier = Modifier.fillMaxWidth(0.75f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutLinedButton("Male", onClick = { /* TODO: Set personality to Friendly */ }, modifier = Modifier.weight(1f))

                OutLinedButton("Female", onClick = { /* TODO: Set personality to Friendly */ }, modifier = Modifier.weight(1f))

            }

            Spacer(modifier = Modifier.weight(1f))


            OutlinedButton(
                onClick = { /* TODO: Set personality to Friendly */ },
                modifier = Modifier
                    .fillMaxWidth(0.75f)
                    .height(50.dp)
                    .padding(end = 8.dp),
                border = BorderStroke(0.8.dp, Color(0xFF305656)),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFADCDCC))
            ) {
                Text(text = "Continue")

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = painterResource(R.drawable.ic_arrow_forward),
                    contentDescription = "Next",
                    tint = Color(0xFFADCDCC),
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))





        }

    }
}

@Composable
fun OutLinedButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .height(50.dp)
            .padding(end = 8.dp),
        border = BorderStroke(0.8.dp, Color(0xFF305656)),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xFFADCDCC))
    ) {
        Text(text = text)
    }

}



@Preview(showBackground = true)
@Composable
fun OnboardingScreenThreePreview() {
    OnboardingScreenThree()
}