package com.example.mitravani.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mitravani.domain.model.UserProfile
import com.example.mitravani.domain.usecase.SaveUserProfileUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val saveUserProfileUseCase: SaveUserProfileUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(OnboardingUiState())
    val uiState: StateFlow<OnboardingUiState> = _uiState.asStateFlow()

    fun onUserNameChange(name: String) {
        _uiState.update { it.copy(userName = name) }
    }

    fun onCompanionNameChange(name: String) {
        _uiState.update { it.copy(companionName = name) }
    }

    fun onPersonalityChange(personality: String) {
        _uiState.update { it.copy(personality = personality) }
    }

    fun onGenderChange(gender: String) {
        _uiState.update { it.copy(gender = gender) }
    }

    fun saveProfile(onSuccess: () -> Unit) {
        val state = _uiState.value

        if (state.userName.isBlank()) {
            _uiState.update { it.copy(error = "Please enter your name") }
            return
        }

        viewModelScope.launch {
            _uiState.update { it.copy(isSaving = true, error = null) }

            try {
                saveUserProfileUseCase(
                    UserProfile(
                        userName = state.userName.trim(),
                        companionName = state.companionName
                            .trim()
                            .ifBlank { "Mitravani" },
                        personality = state.personality,
                        gender = state.gender
                    )
                )
                _uiState.update { it.copy(isSaving = false, isComplete = true) }
                onSuccess()
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(isSaving = false, error = "Something went wrong, try again")
                }
            }
        }
    }

    fun clearError() {
        _uiState.update { it.copy(error = null) }
    }
}