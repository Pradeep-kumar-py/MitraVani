package com.example.mitravani.ui.home

import com.example.mitravani.domain.model.Message

data class HomeUiState(
    val messages: List<Message> = emptyList(),
    val streamingText: String = "",       // token being streamed right now
    val isStreaming: Boolean = false,
    val inputText: String = ""
)