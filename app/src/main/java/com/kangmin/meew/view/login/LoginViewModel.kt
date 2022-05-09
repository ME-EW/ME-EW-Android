package com.kangmin.meew.view.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.helper.KakaoLoginHelper
import com.example.domain.listener.LoginListener
import com.example.domain.usecase.LoginUseCase
import com.kakao.sdk.auth.model.OAuthToken
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.MeewApplication
import com.kangmin.meew.util.Dlog
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val kakaoLogin: KakaoLoginHelper
) : BaseViewModel() {

    private val _loginSuccess = MutableLiveData(false)
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    private var _kakaoToken = ""
    val kakaoToken: String
        get() = _kakaoToken

    fun loginKakao(context: Context) {
        if (MeewApplication.DEBUG) {
            _loginSuccess.postValue(true)
            return
        }

        kakaoLogin.loginKakao(
            context,
            object : LoginListener {
                override fun onSuccess(token: String) {
                    _kakaoToken = token
                    _loginSuccess.postValue(true)
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
            if (throwable != null) {
                Dlog.e(throwable.stackTrace.toString())
            } else if (oAuthToken != null) {
                _kakaoToken = oAuthToken.accessToken
                _loginSuccess.postValue(true)
            }
        }
    }
}