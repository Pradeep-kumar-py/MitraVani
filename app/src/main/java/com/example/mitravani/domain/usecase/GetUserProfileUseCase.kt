package com.example.mitravani.domain.usecase

import com.example.mitravani.domain.model.UserProfile
import com.example.mitravani.domain.repository.UserProfileRepository

class GetUserProfileUseCase(
    private val repository: UserProfileRepository
) {
    suspend operator fun invoke(): UserProfile? = repository.getProfile()
}