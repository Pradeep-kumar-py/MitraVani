package com.example.mitravani.di

import androidx.room.Room
import com.example.mitravani.data.local.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "mitravani_db"
        )
            .fallbackToDestructiveMigration() // fine during dev, remove before launch
            .build()
    }

    single { get<AppDatabase>().messageDao() }
    single { get<AppDatabase>().userProfileDao() }
    single { get<AppDatabase>().memoryDao() }
    single { get<AppDatabase>().sessionDao() }
}