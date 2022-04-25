package com.kangmin.meew.view.login

import android.content.Context
import com.example.data.helper.KakaoLoginHelper
import com.example.domain.listener.LoginListener
import com.example.domain.usecase.LoginUseCase
import com.kakao.sdk.auth.model.OAuthToken
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.util.Dlog
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

    fun loginKakao(context: Context) {
        kakaoLogin.loginKakao(
            context,
            object : LoginListener {
            override fun onSuccess() {
                Dlog.i("KakaoLoginSuccess")
            }

            override fun onFailed(throwable: Throwable?) {
                Dlog.e(throwable?.stackTrace.toString())
            }

            override fun userCanceled() {
                Dlog.i("User Canceled")
            }
        }
        ) { oAuthToken: OAuthToken?, throwable: Throwable? ->
            // callback with 카카오 계정으로 로그인
        }
    }
}