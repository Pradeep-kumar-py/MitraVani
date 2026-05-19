package com.example.mitravani.ui.onboarding

data class OnboardingUiState(
    val userName: String = "",
    val companionName: String = "",
    val personality: String = "Friendly",
    val gender: String = "Female",
    val isSaving: Boolean = false,
    val isComplete: Boolean = false,
    val error: String? = null
)