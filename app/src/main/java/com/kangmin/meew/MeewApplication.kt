package com.kangmin.meew

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kangmin.meew.util.isDebuggable
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MeewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 카카오 SDK 초기화
        KakaoSdk.init(this, getString(R.string.KAKAO_NATIVE_APP_KEY))

        DEBUG = this.isDebuggable()
    }

    companion object {
        var DEBUG = false
    }
}