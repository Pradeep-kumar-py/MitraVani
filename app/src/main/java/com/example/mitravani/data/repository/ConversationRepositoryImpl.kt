package com.example.mitravani.data.repository

import com.example.mitravani.data.local.FakeChatDataSource
import com.example.mitravani.domain.model.Message
import com.example.mitravani.domain.repository.ConversationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ConversationRepositoryImpl(
    private val fakeChatDataSource: FakeChatDataSource
) : ConversationRepository {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())

    override fun streamResponse(userMessage: String): Flow<String> =
        fakeChatDataSource.streamResponse(userMessage)

    override suspend fun saveMessage(message: Message) {
        _messages.update { it + message }
    }

    override fun getMessages(): Flow<List<Message>> = _messages.asStateFlow()
}