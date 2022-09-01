package com.kangmin.meew.view.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.helper.KakaoLoginHelper
import com.example.domain.listener.LoginListener
import com.example.domain.usecase.LoginUseCase
import com.kakao.sdk.auth.model.OAuthToken
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.MeewApplication
import com.kangmin.meew.util.Dlog
import com.kangmin.meew.util.FlowApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val kakaoLogin: KakaoLoginHelper
) : BaseViewModel() {

    private val _loginSuccessState = MutableStateFlow<Boolean?>(null)
    val loginSuccessState: StateFlow<Boolean?> = _loginSuccessState

    private var _kakaoToken = ""
    val kakaoToken: String
        get() = _kakaoToken

    fun loginKakao(context: Context) {
        kakaoLogin.loginKakao(
            context,
            object : LoginListener {
                override fun onSuccess(token: String) {
                    _kakaoToken = token
                    callLogin()
                }

                override fun onFailed(throwable: Throwable?) {
                    Dlog.e(throwable?.message.toString())
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
                callLogin()
            }
        }
    }

    private fun callLogin() {
        _loginSuccessState.value = false
        viewModelScope.launch {
            FlowApi { loginUseCase.loginFlow(_kakaoToken) }.FlowBuilder()
                .onSuccess {
                    _loginSuccessState.value = it
                }.onHttpException {
                    _toastMsg.postValue("로그인에 실패했습니다.err:$it")
                }.onEtcException {
                    _toastMsg.postValue("로그인에 실패했습니다.")
                }.build()
        }
    }
}