package com.kangmin.meew.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    @Named("MEEW")
    fun provideSharePreference(
        @ApplicationContext context: Context
    ) = context.getSharedPreferences("meew_local", Context.MODE_PRIVATE)

}