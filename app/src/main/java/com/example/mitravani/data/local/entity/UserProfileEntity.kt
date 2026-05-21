package com.example.mitravani.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_profile")
data class UserProfileEntity(
    @PrimaryKey
    val id: Int = 1,           // single row — always upsert with id=1
    val userName: String = "",
    val companionName: String = "Mitravani",
    val personality: String = "Friendly",  // Friendly/Romantic/Playful/Supportive
    val gender: String = "Female",
    val backstory: String = "",
    val createdAt: Long = System.currentTimeMillis()
)