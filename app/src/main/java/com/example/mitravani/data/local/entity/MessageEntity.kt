package com.example.mitravani.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class MessageEntity(
    @PrimaryKey
    val id: String,
    val text: String,
    val sender: String,        // "USER" or "MITRAVANI"
    val sessionId: String,     // groups messages by conversation session
    val timestamp: Long = System.currentTimeMillis()
)