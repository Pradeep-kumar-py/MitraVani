package com.example.mitravani.ui.memory

import com.example.mitravani.domain.model.Memory
import com.example.mitravani.domain.model.UserProfile

data class MemoryUiState(
    val profile: UserProfile? = null,
    val memories: List<Memory> = emptyList(),
    val backstory: String = "",
    val isLoading: Boolean = true,
    val showAddMemorySheet: Boolean = false,
    val showBackstorySheet: Boolean = false,
    val newMemoryText: String = "",
    val newBackstoryText: String = "",
    val error: String? = null
)