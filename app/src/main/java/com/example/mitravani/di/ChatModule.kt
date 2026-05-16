package com.example.mitravani.di

import com.example.mitravani.data.local.FakeChatDataSource
import com.example.mitravani.data.repository.ConversationRepositoryImpl
import com.example.mitravani.domain.repository.ConversationRepository
import com.example.mitravani.domain.usecase.SendMessageUseCase
import com.example.mitravani.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val chatModule = module {
    single { FakeChatDataSource() }
    single<ConversationRepository> { ConversationRepositoryImpl(get()) }
    factory { SendMessageUseCase(get()) }
    viewModel { HomeViewModel(get(), get()) }
}