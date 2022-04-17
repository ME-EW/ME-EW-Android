package com.kangmin.meew.di

import android.content.Context
import com.example.data.helper.KakaoLoginHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LoginModule {

    @Singleton
    @Provides
    @Named("KakaoLogin")
    fun provideKakaoLoginHelper(
        @ApplicationContext context: Context
    ): KakaoLoginHelper = KakaoLoginHelper(context)
}