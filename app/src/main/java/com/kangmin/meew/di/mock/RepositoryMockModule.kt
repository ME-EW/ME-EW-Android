package com.kangmin.meew.di.mock

import com.example.data.impl.mock.CharacterRepositoryMockImpl
import com.example.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryMockModule {

    @Binds
    @Singleton
    @Named("CharacterMock")
    abstract fun bindCharacterRepository(characterRepo: CharacterRepositoryMockImpl): CharacterRepository
}