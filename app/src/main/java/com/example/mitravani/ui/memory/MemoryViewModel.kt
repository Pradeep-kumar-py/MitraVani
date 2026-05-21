package com.example.mitravani.ui.memory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mitravani.domain.model.Memory
import com.example.mitravani.domain.model.MemoryCategory
import com.example.mitravani.domain.repository.MemoryRepository
import com.example.mitravani.domain.repository.UserProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class MemoryViewModel(
    private val userProfileRepository: UserProfileRepository,
    private val memoryRepository: MemoryRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(MemoryUiState())
    val uiState: StateFlow<MemoryUiState> = _uiState.asStateFlow()

    init {
        loadProfile()
        observeMemories()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            userProfileRepository.observeProfile().collect { profile ->
                _uiState.update {
                    it.copy(
                        profile = profile,
                        newBackstoryText = profile?.backstory ?: "",
                        isLoading = false
                    )
                }
            }
        }
    }

    private fun observeMemories() {
        viewModelScope.launch {
            memoryRepository.observeAll().collect { memories ->
                _uiState.update { it.copy(memories = memories) }
            }
        }
    }

    // — Add Memory Sheet —
    fun onShowAddMemory() = _uiState.update { it.copy(showAddMemorySheet = true) }
    fun onHideAddMemory() = _uiState.update {
        it.copy(showAddMemorySheet = false, newMemoryText = "")
    }
    fun onNewMemoryTextChange(text: String) = _uiState.update { it.copy(newMemoryText = text) }

    fun saveMemory() {
        val text = _uiState.value.newMemoryText.trim()
        if (text.isBlank()) return

        viewModelScope.launch {
            memoryRepository.insertMemory(
                Memory(
                    id = UUID.randomUUID().toString(),
                    content = text,
                    category = MemoryCategory.GENERAL,
                    importance = 3
                )
            )
            onHideAddMemory()
        }
    }

    fun deleteMemory(memory: Memory) {
        viewModelScope.launch {
            memoryRepository.deleteMemory(memory.id)
        }
    }

    // — Backstory Sheet —
    fun onShowBackstory() = _uiState.update { it.copy(showBackstorySheet = true) }
    fun onHideBackstory() = _uiState.update { it.copy(showBackstorySheet = false) }
    fun onBackstoryTextChange(text: String) = _uiState.update { it.copy(newBackstoryText = text) }

    fun saveBackstory() {
        viewModelScope.launch {
            userProfileRepository.updateBackstory(_uiState.value.newBackstoryText.trim())
            onHideBackstory()
        }
    }
}