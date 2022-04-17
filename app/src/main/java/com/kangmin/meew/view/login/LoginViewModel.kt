package com.kangmin.meew.view.login

import com.example.data.helper.KakaoLoginHelper
import com.example.domain.listener.LoginListener
import com.example.domain.usecase.LoginUseCase
import com.kakao.sdk.auth.model.OAuthToken
import com.kangmin.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val kakaoLogin: KakaoLoginHelper
) : BaseViewModel() {

    init {
        _toastMsg.postValue(loginUseCase.getTest())
    }

    fun loginKakao() {
        kakaoLogin.loginKakao(object : LoginListener {
            override fun onSuccess() {

            }

            override fun onFailed(throwable: Throwable?) {

            }

            override fun userCanceled() {
            }
        }
        ) { oAuthToken: OAuthToken?, throwable: Throwable? ->
            // callback with KakaoAccount
        }
    }
}