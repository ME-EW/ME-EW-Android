package com.example.domain.usecase

import com.example.domain.repository.LocalRepository
import com.example.domain.repository.LoginRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor (
    private val localRepo: LocalRepository,
    private val loginRepo: LoginRepository
) {
    fun checkUserDataInLocal() = flow {
        emit(localRepo.getUserDataInLocal().accessToken.isNotBlank())
    }

    fun loginFlow(accessToken: String? = null) = flow {
        kotlin.runCatching {
            loginRepo.postLogin(accessToken ?: localRepo.getUserDataInLocal().accessToken)
        }.onSuccess {
            localRepo.setUserDataInLocal(user = it)
            emit(true)
        }
    }
}