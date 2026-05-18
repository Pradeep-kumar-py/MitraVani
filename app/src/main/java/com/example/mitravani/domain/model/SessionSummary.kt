package com.example.mitravani.domain.model

data class SessionSummary(
    val sessionId: String,
    val summary: String,
    val messageCount: Int,
    val createdAt: Long
)