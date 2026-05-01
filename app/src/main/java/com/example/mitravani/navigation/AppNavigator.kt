package com.example.mitravani.navigation

//import Navigator
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mitravani.ui.home.HomeScreen
import com.example.mitravani.ui.onboarding.OnboardingScreenOne
import com.example.mitravani.ui.onboarding.OnboardingScreenThree
import com.example.mitravani.ui.onboarding.OnboardingScreenTwo
import com.example.mitravani.ui.theme.LocalMitravaniColors
import com.example.mitravani.ui.voice.VoiceScreen


val LocalNavigator = staticCompositionLocalOf<Navigator> {
    error("No navigator provided")
}

@Composable
fun AppNavigator() {
    val backStack = rememberNavBackStack(Screen.OnboardingScreenOne)
    val navigator = remember { Navigator(backStack) }
    val colors = LocalMitravaniColors.current
    CompositionLocalProvider(
        LocalNavigator provides navigator
    ) {
        Scaffold(
            containerColor = colors.background
        ) { padding ->
            NavDisplay(
                backStack = backStack,
                onBack = { navigator.pop() },
                entryProvider = appEntryProvider(),
                modifier = Modifier.padding(padding)
            )
        }
    }
}


@Composable
private fun appEntryProvider() = entryProvider<NavKey> {

    entry<Screen.OnboardingScreenOne> { OnboardingScreenOne() }
    entry<Screen.OnboardingScreenTwo> { OnboardingScreenTwo() }
    entry<Screen.OnboardingScreenThree> { OnboardingScreenThree() }

    entry<Screen.Home> { HomeScreen() }

    entry<Screen.Voice> { VoiceScreen() }





}
