package com.example.mitravani.data.repository

import com.example.mitravani.data.local.FakeChatDataSource
import com.example.mitravani.data.local.dao.MessageDao
import com.example.mitravani.data.local.mapper.toEntity
import com.example.mitravani.data.local.mapper.toDomain
import com.example.mitravani.domain.model.Message
import com.example.mitravani.domain.repository.ConversationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ConversationRepositoryImpl(
    private val fakeChatDataSource: FakeChatDataSource,
    private val messageDao: MessageDao,
    private val sessionId: String   // passed in from module
) : ConversationRepository {

    override fun streamResponse(userMessage: String): Flow<String> =
        fakeChatDataSource.streamResponse(userMessage)

    override suspend fun saveMessage(message: Message) {
        messageDao.insertMessage(message.toEntity(sessionId))
    }

    override fun getMessages(): Flow<List<Message>> =
        messageDao.getMessagesBySession(sessionId)
            .map { entities -> entities.map { it.toDomain() } }
}