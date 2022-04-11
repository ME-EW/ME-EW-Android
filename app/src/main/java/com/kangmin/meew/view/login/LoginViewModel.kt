package com.kangmin.meew.view.login

import com.example.domain.usecase.LoginUseCase
import com.kangmin.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    init {
        _toastMsg.postValue(loginUseCase.getTest())
    }
}