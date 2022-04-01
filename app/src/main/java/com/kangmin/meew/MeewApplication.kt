package com.kangmin.meew

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class MeewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // 카카오 SDK 초기화
        KakaoSdk.init(this, getString(R.string.KAKAO_NATIVE_APP_KEY))
    }
}