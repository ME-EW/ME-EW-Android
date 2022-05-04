package com.example.domain.listener

interface LoginListener {
    fun onSuccess(token: String)
    fun onFailed(throwable: Throwable?)
    fun userCanceled()
}