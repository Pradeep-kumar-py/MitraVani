package com.example.mitravani.domain.repository

import com.example.mitravani.domain.model.Memory
import kotlinx.coroutines.flow.Flow

interface MemoryRepository {
    fun observeAll(): Flow<List<Memory>>
    suspend fun getTopMemories(limit: Int = 10): List<Memory>
    suspend fun insertMemory(memory: Memory)
    suspend fun deleteMemory(id: String)
}