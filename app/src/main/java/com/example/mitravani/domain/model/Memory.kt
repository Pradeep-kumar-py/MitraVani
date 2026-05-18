package com.example.mitravani.domain.model

data class Memory(
    val id: String,
    val content: String,
    val category: MemoryCategory,
    val importance: Int = 1,
    val timestamp: Long = System.currentTimeMillis()
)

enum class MemoryCategory {
    NAME, HABIT, EMOTION, GOAL, RELATIONSHIP, GENERAL
}