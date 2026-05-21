package com.example.mitravani.data.local.dao

import androidx.room.*
import com.example.mitravani.data.local.entity.UserProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProfile(profile: UserProfileEntity)

    @Query("SELECT * FROM user_profile WHERE id = 1")
    fun observeProfile(): Flow<UserProfileEntity?>

    @Query("SELECT * FROM user_profile WHERE id = 1")
    suspend fun getProfile(): UserProfileEntity?

    @Query("UPDATE user_profile SET userName = :name WHERE id = 1")
    suspend fun updateUserName(name: String)

    @Query("UPDATE user_profile SET companionName = :name WHERE id = 1")
    suspend fun updateCompanionName(name: String)

    @Query("UPDATE user_profile SET personality = :personality WHERE id = 1")
    suspend fun updatePersonality(personality: String)

    @Query("UPDATE user_profile SET backstory = :backstory WHERE id = 1")
    suspend fun updateBackstory(backstory: String)
}