package com.kangmin.meew.util

import android.util.Log
import com.kangmin.meew.MeewApplication
import java.lang.StringBuilder

object Dlog {
    private val TAG = "PASSORDER"

    fun e(msg: String) {
        if (MeewApplication.DEBUG)
            Log.e(TAG, buildLogMsg(msg))
    }

    fun w(msg: String) {
        if (MeewApplication.DEBUG)
            Log.w(TAG, buildLogMsg(msg))
    }

    fun i(msg: String) {
        if (MeewApplication.DEBUG)
            Log.i(TAG, buildLogMsg(msg))
    }

    fun d(msg: String) {
        if (MeewApplication.DEBUG)
            Log.d(TAG, buildLogMsg(msg))
    }

    fun v(msg: String) {
        if (MeewApplication.DEBUG)
            Log.v(TAG, buildLogMsg(msg))
    }


    private fun buildLogMsg(msg: String): String {
        val ste = Thread.currentThread().stackTrace[4]

        val sb = StringBuilder()

        sb.apply {
            append("[")
            append(ste.fileName.replace(".java",""))
            append("::")
            append(ste.methodName)
            append("]")
            append("] ")
            append(msg)
        }

        return sb.toString()
    }
}