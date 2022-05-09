package com.example.domain.usecase

import com.example.domain.repository.LocalRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginUseCase @Inject constructor (
    private val sharedPref: LocalRepository
) {
}