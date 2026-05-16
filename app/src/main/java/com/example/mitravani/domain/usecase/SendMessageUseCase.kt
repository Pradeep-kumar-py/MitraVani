package com.example.mitravani.domain.usecase

import com.example.mitravani.domain.model.Message
import com.example.mitravani.domain.model.Sender
import com.example.mitravani.domain.repository.ConversationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart

class SendMessageUseCase(
    private val repository: ConversationRepository
) {
    suspend operator fun invoke(prompt: String): Flow<String> {
        // Save user message first
        repository.saveMessage(Message(text = prompt, sender = Sender.USER))
        return repository.streamResponse(prompt)
    }
}