package com.example.data.helper

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.domain.listener.LoginListener
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class KakaoLoginHelper @Inject constructor(
    @ApplicationContext private val applicationContext: Context
) {
    private val TAG = "KAKAO"

    init {
        KakaoSdk.init(applicationContext, "e8b810e71ca9869160f85eb6d33a8c5d")
    }

    fun loginKakao(
        context: Context,
        loginListener: LoginListener,
        callbackWithKakaoAccount: (OAuthToken?, Throwable?) -> Unit
    ) {

        if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
            UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
                if (error != null) {
                    Log.e(TAG, "카카오 로그인 실패")

                    // 유저의 취소로 인한 로그인 실패
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        loginListener.userCanceled()
                        return@loginWithKakaoTalk
                    }

                    loginListener.onFailed(error)

                } else if (token != null) {
                    loginListener.onSuccess()
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(
                context,
                callback = callbackWithKakaoAccount
            )
        }

    }
}