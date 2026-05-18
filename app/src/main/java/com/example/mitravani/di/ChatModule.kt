package com.example.mitravani.di

import com.example.mitravani.data.local.FakeChatDataSource
import com.example.mitravani.data.local.dao.MessageDao
import com.example.mitravani.data.repository.ConversationRepositoryImpl
import com.example.mitravani.domain.repository.ConversationRepository
import com.example.mitravani.domain.usecase.SendMessageUseCase
import com.example.mitravani.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import java.util.UUID

val chatModule = module {
    single { FakeChatDataSource() }

    // Session ID — new session each app launch for now
    // Later: load last session from SessionDao or create new one
    single<ConversationRepository> {
        ConversationRepositoryImpl(
            fakeChatDataSource = get(),
            messageDao = get(),
            sessionId = UUID.randomUUID().toString()
        )
    }

    factory { SendMessageUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}