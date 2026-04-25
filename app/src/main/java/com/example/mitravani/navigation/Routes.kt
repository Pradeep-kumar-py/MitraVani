// In Routes.kt
package com.example.mitravani.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen: NavKey {
    @Serializable
    data object Splash : Screen

    // Auth screens
    @Serializable
    data object Login : Screen

    @Serializable
    data object Signup : Screen

    @Serializable
    data object Home : Screen

    @Serializable
    data object Settings : Screen

}
