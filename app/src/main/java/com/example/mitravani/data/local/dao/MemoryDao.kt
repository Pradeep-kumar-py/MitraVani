package com.example.mitravani.data.local.dao

import androidx.room.*
import com.example.mitravani.data.local.entity.MemoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemory(memory: MemoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMemories(memories: List<MemoryEntity>)

    // Pull top memories by importance — used to build prompt context
    @Query("SELECT * FROM memories ORDER BY importance DESC, timestamp DESC LIMIT :limit")
    suspend fun getTopMemories(limit: Int = 10): List<MemoryEntity>

    @Query("SELECT * FROM memories WHERE category = :category ORDER BY importance DESC")
    suspend fun getMemoriesByCategory(category: String): List<MemoryEntity>

    @Query("SELECT * FROM memories ORDER BY timestamp DESC")
    fun observeAllMemories(): Flow<List<MemoryEntity>>

    @Query("DELETE FROM memories WHERE id = :id")
    suspend fun deleteMemory(id: String)

    @Query("SELECT COUNT(*) FROM memories")
    suspend fun getMemoryCount(): Int
}