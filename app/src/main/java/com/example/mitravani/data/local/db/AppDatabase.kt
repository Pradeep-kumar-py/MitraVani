package com.example.mitravani.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mitravani.data.local.dao.MemoryDao
import com.example.mitravani.data.local.dao.MessageDao
import com.example.mitravani.data.local.dao.SessionDao
import com.example.mitravani.data.local.dao.UserProfileDao
import com.example.mitravani.data.local.entity.MemoryEntity
import com.example.mitravani.data.local.entity.MessageEntity
import com.example.mitravani.data.local.entity.SessionEntity
import com.example.mitravani.data.local.entity.UserProfileEntity

@Database(
    entities = [
        MessageEntity::class,
        UserProfileEntity::class,
        MemoryEntity::class,
        SessionEntity::class
    ],
    version = 1,
    exportSchema = false  // later: set to true and add migrations when schema changes
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun userProfileDao(): UserProfileDao
    abstract fun memoryDao(): MemoryDao
    abstract fun sessionDao(): SessionDao
}