package com.example.mitravani.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mitravani.domain.model.Message
import com.example.mitravani.domain.model.Sender
import com.example.mitravani.domain.repository.ConversationRepository
import com.example.mitravani.domain.usecase.SendMessageUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val sendMessageUseCase: SendMessageUseCase,
    private val conversationRepository: ConversationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        observeMessages()
    }

    private fun observeMessages() {
        viewModelScope.launch {
            conversationRepository.getMessages().collect { messages ->
                _uiState.update { it.copy(messages = messages) }
            }
        }
    }

    fun onInputChange(newText: String) {
        _uiState.update {
            it.copy(inputText = newText)
        }
    }

    fun sendMessage(text: String) {
        if (text.isBlank() || _uiState.value.isStreaming) return

        _uiState.update { it.copy(inputText = "") }

        viewModelScope.launch {
            var streamedSoFar = ""

            sendMessageUseCase(text)
                .onStart {
                    _uiState.update { it.copy(isStreaming = true, streamingText = "") }
                }
                .onEach { token ->
                    streamedSoFar += token
                    _uiState.update { it.copy(streamingText = streamedSoFar) }
                }
                .onCompletion {
                    // Commit completed message to list
                    conversationRepository.saveMessage(
                        Message(text = streamedSoFar.trim(), sender = Sender.MITRAVANI)
                    )
                    _uiState.update { it.copy(isStreaming = false, streamingText = "") }
                }
                .launchIn(this)
        }
    }
}