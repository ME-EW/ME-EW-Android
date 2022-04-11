package com.kangmin.meew.di

import com.example.data.impl.LocalRepositoryImpl
import com.example.domain.repository.LocalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    @Named("SharedPref")
    abstract fun bindSharePrefRepository(localRepo: LocalRepositoryImpl): LocalRepository
}