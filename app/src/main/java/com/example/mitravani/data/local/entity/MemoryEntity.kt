package com.example.mitravani.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "memories")
data class MemoryEntity(
    @PrimaryKey
    val id: String,
    val content: String,       // "User's name is Arjun"
    val category: String,      // "NAME" | "HABIT" | "EMOTION" | "GOAL" | "RELATIONSHIP"
    val importance: Int = 1,   // 1–5, higher = injected first into prompt
    val sessionId: String,     // which session this was extracted from
    val timestamp: Long = System.currentTimeMillis()
)