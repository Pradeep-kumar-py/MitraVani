package com.example.mitravani.domain.repository

import com.example.mitravani.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {
    suspend fun saveProfile(profile: UserProfile)
    suspend fun getProfile(): UserProfile?
    fun observeProfile(): Flow<UserProfile?>
    suspend fun isOnboardingComplete(): Boolean

    suspend fun updateBackstory(backstory: String)
}