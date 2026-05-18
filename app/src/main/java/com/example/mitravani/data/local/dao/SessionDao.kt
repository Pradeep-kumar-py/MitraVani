package com.example.mitravani.data.local.dao

import androidx.room.*
import com.example.mitravani.data.local.entity.SessionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertSession(session: SessionEntity)

    @Query("SELECT * FROM sessions ORDER BY updatedAt DESC LIMIT 1")
    suspend fun getLatestSession(): SessionEntity?

    @Query("SELECT * FROM sessions ORDER BY updatedAt DESC")
    fun observeAllSessions(): Flow<List<SessionEntity>>

    @Query("UPDATE sessions SET summary = :summary, updatedAt = :updatedAt WHERE id = :sessionId")
    suspend fun updateSummary(sessionId: String, summary: String, updatedAt: Long = System.currentTimeMillis())

    @Query("UPDATE sessions SET messageCount = messageCount + 1, updatedAt = :updatedAt WHERE id = :sessionId")
    suspend fun incrementMessageCount(sessionId: String, updatedAt: Long = System.currentTimeMillis())
}