package com.example.mitravani.domain.repository

import com.example.mitravani.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface ConversationRepository {
    fun streamResponse(userMessage: String): Flow<String>   // emits tokens one by one
    suspend fun saveMessage(message: Message)
    fun getMessages(): Flow<List<Message>>
}