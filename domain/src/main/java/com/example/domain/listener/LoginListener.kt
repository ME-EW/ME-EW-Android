package com.example.domain.listener

interface LoginListener {
    fun onSuccess()
    fun onFailed(throwable: Throwable?)
    fun userCanceled()
}