package com.example.mitravani.domain.usecase

import com.example.mitravani.domain.repository.UserProfileRepository

class CheckOnboardingUseCase(
    private val repository: UserProfileRepository
) {
    suspend operator fun invoke(): Boolean = repository.isOnboardingComplete()
}