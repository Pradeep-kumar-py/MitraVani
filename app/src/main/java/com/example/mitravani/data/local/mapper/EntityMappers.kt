package com.example.mitravani.data.local.mapper

import com.example.mitravani.data.local.entity.MemoryEntity
import com.example.mitravani.data.local.entity.MessageEntity
import com.example.mitravani.data.local.entity.UserProfileEntity
import com.example.mitravani.domain.model.Memory
import com.example.mitravani.domain.model.MemoryCategory
import com.example.mitravani.domain.model.Message
import com.example.mitravani.domain.model.Sender
import com.example.mitravani.domain.model.UserProfile

fun MessageEntity.toDomain() = Message(
    id = id,
    text = text,
    sender = if (sender == "USER") Sender.USER else Sender.MITRAVANI,
    timestamp = timestamp
)

fun Message.toEntity(sessionId: String) = MessageEntity(
    id = id,
    text = text,
    sender = sender.name,
    sessionId = sessionId,
    timestamp = timestamp
)

fun UserProfileEntity.toDomain() = UserProfile(
    userName = userName,
    companionName = companionName,
    personality = personality,
    gender = gender,
    backstory = backstory
)

fun UserProfile.toEntity() = UserProfileEntity(
    id = 1,
    userName = userName,
    companionName = companionName,
    personality = personality,
    gender = gender,
    backstory = backstory
)

fun MemoryEntity.toDomain() = Memory(
    id = id,
    content = content,
    category = runCatching { MemoryCategory.valueOf(category) }
        .getOrDefault(MemoryCategory.GENERAL),
    importance = importance,
    timestamp = timestamp
)

fun Memory.toEntity(sessionId: String) = MemoryEntity(
    id = id,
    content = content,
    category = category.name,
    importance = importance,
    sessionId = sessionId,
    timestamp = timestamp
)