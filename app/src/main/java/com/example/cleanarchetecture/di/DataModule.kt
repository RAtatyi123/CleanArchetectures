package com.example.cleanarchetecture.di

import android.content.Context
import com.example.cleanarchetecture.data.repository.UserRepositoryImpl
import com.example.cleanarchetecture.data.storage.UserStorage
import com.example.cleanarchetecture.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.cleanarchetecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {


    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }

}
