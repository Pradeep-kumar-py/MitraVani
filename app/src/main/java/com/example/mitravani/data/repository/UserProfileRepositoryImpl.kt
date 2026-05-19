package com.example.mitravani.data.repository

import com.example.mitravani.data.local.dao.UserProfileDao
import com.example.mitravani.data.local.mapper.toDomain
import com.example.mitravani.data.local.mapper.toEntity
import com.example.mitravani.domain.model.UserProfile
import com.example.mitravani.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserProfileRepositoryImpl(
    private val userProfileDao: UserProfileDao
) : UserProfileRepository {

    override suspend fun saveProfile(profile: UserProfile) {
        userProfileDao.upsertProfile(profile.toEntity())
    }

    override suspend fun getProfile(): UserProfile? =
        userProfileDao.getProfile()?.toDomain()

    override fun observeProfile(): Flow<UserProfile?> =
        userProfileDao.observeProfile().map { it?.toDomain() }

    // Onboarding is complete if userName is not blank
    override suspend fun isOnboardingComplete(): Boolean =
        userProfileDao.getProfile()?.userName?.isNotBlank() == true
}