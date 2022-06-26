package com.example.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.example.data.UserProtoData
import com.example.data.datastore.serializer.UserSerializer
import com.example.domain.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Singleton

@Singleton
class ProtoDataStore(
    @ApplicationContext private val context: Context
) {
    private val Context.protoDataStore: DataStore<UserProtoData> by dataStore(
        fileName = "user.pb",
        serializer = UserSerializer
    )

    val userData: Flow<User> = context.protoDataStore.data.map {
        User(
            accessToken = it.accessToken,
            refreshToken = it.refreshToken,
        )
    }.catch {
        User(accessToken = "", refreshToken = "")
    }

    suspend fun setUserInDataStore(user: User) {
        context.protoDataStore.updateData {
            it.toBuilder()
                .setAccessToken(user.accessToken)
                .setRefreshToken(user.refreshToken)
                .build()
        }
    }
}