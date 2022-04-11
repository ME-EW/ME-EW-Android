package com.example.data.impl

import android.content.SharedPreferences
import com.example.domain.repository.LocalRepository
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LocalRepositoryImpl @Inject constructor(
    @Named("MEEW") private val sharedPref: SharedPreferences
) : LocalRepository {

    override var test: String?
        get() = sharedPref.getString("test", "test")
        set(value) {
            with(sharedPref.edit()) {
                putString("test", value)
                apply()
            }
        }
}