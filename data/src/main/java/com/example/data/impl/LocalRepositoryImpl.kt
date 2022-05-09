package com.example.data.impl

import android.content.SharedPreferences
import com.example.domain.repository.LocalRepository
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LocalRepositoryImpl @Inject constructor(
    @Named("MEEW_SharedPref") private val sharedPref: SharedPreferences
) : LocalRepository {
}