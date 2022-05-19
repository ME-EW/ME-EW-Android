package com.kangmin.meew.util

import android.content.Context
import android.content.pm.ApplicationInfo
import android.widget.Toast

/**
 * Dlog를 남기기 위한 사전 작업
 * 현재 빌드 상태가 Debug모드인지 확인하기 위해 Application 단위에서 사용
 */
fun Context.isDebuggable(): Boolean {
    var debuggable = false

    val pm = this.packageManager

    kotlin.runCatching {
        pm.getApplicationInfo(this.packageName, 0)
    }.onSuccess {
        debuggable = (0 != (it.flags and ApplicationInfo.FLAG_DEBUGGABLE))
    }.onFailure {
        debuggable = false
    }

    return debuggable
}

fun Context?.showToast(msg: String, time: Int = Toast.LENGTH_SHORT) {
    this?.let {
        Toast.makeText(it, msg, time).show()
    }
}