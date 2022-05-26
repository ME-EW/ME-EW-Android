package com.kangmin.meew.di

import com.example.data.service.CharacterService
import com.example.data.service.LoginService
import com.example.data.service.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val baseUrl = "https://asia-northeast3-meew-server.cloudfunctions.net/api/"

    private val httpsClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(getHttpLoggingInterceptor())
        .build()

    private val baseBuilder = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(httpsClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideLoginService(): LoginService = baseBuilder.create(LoginService::class.java)

    @Provides
    @Singleton
    fun provideUserService(): UserService = baseBuilder.create(UserService::class.java)

    @Provides
    @Singleton
    fun provideCharacterService(): CharacterService = baseBuilder.create(CharacterService::class.java)
}