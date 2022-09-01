package com.kangmin.meew.view.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.LoginUseCase
import com.kangmin.base.BaseViewModel
import com.kangmin.meew.util.FlowApi
import com.kangmin.meew.util.FlowApi.FlowBuilder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    private val _userInLocal = MutableLiveData<Boolean>()
    val userInLocal: LiveData<Boolean> = _userInLocal

    private val _isSuccessLogin = MutableLiveData<Boolean>()
    val isSuccessLogin: LiveData<Boolean> = _isSuccessLogin

    fun checkAutoLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            loginUseCase.checkUserDataInLocal().catch {
                _userInLocal.postValue(false)
            }.collect {
                _userInLocal.postValue(it)
            }
        }
    }

    fun login() {
        viewModelScope.launch(Dispatchers.IO) {
            FlowApi(loginUseCase.loginFlow()).FlowBuilder()
                .onHttpException { code ->
                    _toastMsg.postValue("http 에러")
//                    _toastMsg.postValue(code.toString())
                }
                .onEtcException {
                    _toastMsg.postValue("서버 에러")
                }
                .onSuccess { isSuccess ->
                    _isSuccessLogin.postValue(isSuccess)
                }
                .build()
        }
    }
}