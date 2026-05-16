package com.example.mitravani.domain.model

import java.util.UUID

enum class Sender { USER, MITRAVANI }

data class Message(
    val id: String = UUID.randomUUID().toString(),
    val text: String,
    val sender: Sender,
    val timestamp: Long = System.currentTimeMillis()
)