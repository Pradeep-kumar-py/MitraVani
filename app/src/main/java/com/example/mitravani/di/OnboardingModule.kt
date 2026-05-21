package com.example.mitravani.di

import com.example.mitravani.data.repository.MemoryRepositoryImpl
import com.example.mitravani.data.repository.UserProfileRepositoryImpl
import com.example.mitravani.domain.repository.MemoryRepository
import com.example.mitravani.domain.repository.UserProfileRepository
import com.example.mitravani.domain.usecase.CheckOnboardingUseCase
import com.example.mitravani.domain.usecase.GetUserProfileUseCase
import com.example.mitravani.domain.usecase.SaveUserProfileUseCase
import com.example.mitravani.ui.memory.MemoryViewModel
import com.example.mitravani.ui.onboarding.OnboardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onboardingModule = module {
    single<UserProfileRepository> { UserProfileRepositoryImpl(get()) }
    single<MemoryRepository> {
        MemoryRepositoryImpl(
            memoryDao = get(),
            sessionId = "global"   // memories are global, not per-session
        )
    }
    factory { SaveUserProfileUseCase(get()) }
    factory { GetUserProfileUseCase(get()) }
    factory { CheckOnboardingUseCase(get()) }
    viewModel { OnboardingViewModel(get()) }
    viewModel { MemoryViewModel(get(), get()) }
}