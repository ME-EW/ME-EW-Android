package com.example.data.impl

import android.content.SharedPreferences
import com.example.data.datastore.ProtoDataStore
import com.example.domain.model.User
import com.example.domain.repository.LocalRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Singleton
class LocalRepositoryImpl @Inject constructor(
    @Named("MEEW_SharedPref") private val sharedPref: SharedPreferences,
    private val protoDataStore: ProtoDataStore
) : LocalRepository {

    // DataStore에서 유저 정보 가져오기
    override suspend fun getUserDataInLocal(): User {
        return protoDataStore.userData.first()
    }

    override fun setUserDataInLocal(user: User) {
        CoroutineScope(Dispatchers.IO).launch {
            protoDataStore.setUserInDataStore(user)
        }
    }
}