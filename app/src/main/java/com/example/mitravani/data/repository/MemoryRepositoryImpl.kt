package com.example.mitravani.data.repository

import com.example.mitravani.data.local.dao.MemoryDao
import com.example.mitravani.data.local.mapper.toDomain
import com.example.mitravani.data.local.mapper.toEntity
import com.example.mitravani.domain.model.Memory
import com.example.mitravani.domain.repository.MemoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MemoryRepositoryImpl(
    private val memoryDao: MemoryDao,
    private val sessionId: String
) : MemoryRepository {

    override fun observeAll(): Flow<List<Memory>> =
        memoryDao.observeAllMemories().map { list -> list.map { it.toDomain() } }

    override suspend fun getTopMemories(limit: Int): List<Memory> =
        memoryDao.getTopMemories(limit).map { it.toDomain() }

    override suspend fun insertMemory(memory: Memory) {
        memoryDao.insertMemory(memory.toEntity(sessionId))
    }

    override suspend fun deleteMemory(id: String) {
        memoryDao.deleteMemory(id)
    }
}