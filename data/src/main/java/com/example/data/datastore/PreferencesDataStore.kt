package com.example.data.datastore

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

class PreferencesDataStore {
    val Context.dataStore by preferencesDataStore(name = "meew")
}