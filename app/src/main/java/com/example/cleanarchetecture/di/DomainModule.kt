package com.example.cleanarchetecture.di

import com.example.cleanarchetecture.domain.repository.UserRepository
import com.example.cleanarchetecture.domain.usecase.GetUserNameUSeCase
import com.example.cleanarchetecture.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {


    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository) : GetUserNameUSeCase {
        return GetUserNameUSeCase(userRepository = userRepository)
    }
    @Provides
    fun provideSaveUserNameUseCase(userRepository: UserRepository) : SaveUserNameUseCase {
        return SaveUserNameUseCase(userRepository = userRepository)
    }
}