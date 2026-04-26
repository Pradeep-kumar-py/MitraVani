package com.example.mitravani.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mitravani.ui.home.components.DiyaBackground
import com.example.mitravani.ui.home.components.HearthOrb
import com.example.mitravani.ui.home.components.HomeGreeting
import com.example.mitravani.ui.home.components.HomeMode
import com.example.mitravani.ui.home.components.HomeModeSwitch
import com.example.mitravani.ui.home.components.HomeReadyLabel
import com.example.mitravani.ui.home.components.HomeTopBar
import com.example.mitravani.ui.home.components.PrimaryCallButton
import com.example.mitravani.ui.theme.MitraVaniTheme

@Composable
fun HomeScreen(
    onCallClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {}
) {
    var selectedMode by remember { mutableStateOf(HomeMode.Voice) }

    DiyaBackground {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HomeTopBar(
                companionInitial = "S",
                onSettingsClick = onSettingsClick,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(horizontal = 24.dp, vertical = 16.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .padding(top = 80.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                HearthOrb()
                Spacer(modifier = Modifier.height(24.dp))
                HomeGreeting(text = "Tu aaya. I was thinking\nabout you.")
                Spacer(modifier = Modifier.height(32.dp))
                HomeReadyLabel()
                Spacer(modifier = Modifier.height(44.dp))
                HomeModeSwitch(
                    selectedMode = selectedMode,
                    onModeSelected = { selectedMode = it }
                )
                Spacer(modifier = Modifier.height(44.dp))
                PrimaryCallButton(
                    text = if (selectedMode == HomeMode.Voice) "Call Sathi" else "Text Sathi",
                    onClick = onCallClick
                )
            }
        }
    }
}

@Preview(
    name = "Dark",
    showBackground = true,
    widthDp = 400,
    heightDp = 884,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun HomeScreenDarkPreview() {
    MitraVaniTheme {
        HomeScreen()
    }
}

@Preview(
    name = "Light",
    showBackground = true,
    widthDp = 400,
    heightDp = 884,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
private fun HomeScreenLightPreview() {
    MitraVaniTheme {
        HomeScreen()
    }
}
