package com.kangmin.meew

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.kangmin.meew.util.Dlog
import com.kangmin.meew.util.isDebuggable
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MeewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DEBUG = this.isDebuggable()
    }

    companion object {
        var DEBUG = false
    }
}