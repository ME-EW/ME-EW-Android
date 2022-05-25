package com.example.data.datastore.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.example.data.UserProtoData
import java.io.InputStream
import java.io.OutputStream

object UserSerializer : Serializer<UserProtoData> {

    override val defaultValue: UserProtoData
        get() = UserProtoData.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): UserProtoData {
        try {
            return UserProtoData.parseFrom(input)
        } catch (e: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto", e)
        }
    }

    override suspend fun writeTo(t: UserProtoData, output: OutputStream) {
        t.writeTo(output)
    }
}