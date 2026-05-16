package com.example.mitravani.data.local

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeChatDataSource {

    private val responses = listOf(
        "Hey! I'm so glad you reached out. Tell me more about what's on your mind.",
        "That sounds really tough. I'm here for you — take your time.",
        "I completely understand. You're not alone in feeling this way.",
        "Honestly, that's a really interesting thing to think about. What do you think?",
        "I've been thinking about what you said earlier. It means a lot that you shared that."
    )

    fun streamResponse(prompt: String): Flow<String> = flow {
        val reply = responses.random()
        val words = reply.split(" ")
        for (word in words) {
            emit("$word ")
            delay(80L)   // fake typing speed — replace with GemmaEngine later
        }
    }
}