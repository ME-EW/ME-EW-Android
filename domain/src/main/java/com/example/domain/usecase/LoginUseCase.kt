package com.example.domain.usecase

import com.example.domain.repository.LocalRepository
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor (
    private val localRepo: LocalRepository
) {
    fun checkUserDataInLocal() = flow {
        emit(localRepo.getUserDataInLocal().accessToken.isNotBlank())
    }
}