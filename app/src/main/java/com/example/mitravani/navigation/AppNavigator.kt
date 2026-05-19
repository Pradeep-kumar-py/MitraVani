package com.example.mitravani.navigation

//import Navigator
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.mitravani.domain.usecase.CheckOnboardingUseCase
import com.example.mitravani.ui.components.LoadingScreen
import com.example.mitravani.ui.home.HomeScreen
import com.example.mitravani.ui.onboarding.OnboardingScreenOne
import com.example.mitravani.ui.onboarding.OnboardingScreenThree
import com.example.mitravani.ui.onboarding.OnboardingScreenTwo
import com.example.mitravani.ui.theme.LocalMitravaniColors
import com.example.mitravani.ui.voice.VoiceScreen
import org.koin.core.context.GlobalContext.get as getKoin


val LocalNavigator = staticCompositionLocalOf<Navigator> {
    error("No navigator provided")
}

@Composable
fun AppNavigator() {

    val checkOnboarding: CheckOnboardingUseCase = getKoin().get()
    var startScreen by remember { mutableStateOf<Screen?>(null) }

    LaunchedEffect(Unit) {
        startScreen = if (checkOnboarding()) Screen.Home
        else Screen.OnboardingScreenOne
    }

    // Show nothing until we know where to start
    if (startScreen == null) {
        LoadingScreen()
        return
    }

    val backStack = rememberNavBackStack(startScreen!!)
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
