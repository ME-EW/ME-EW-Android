package com.kangmin.meew.util

import android.os.Parcel
import android.os.Parcelable
import kotlinx.coroutines.flow.Flow

class FlowApi() {
    private var httpException: (suspend (errCode: Int) -> Unit)? = null
    private var etcException: (suspend () -> Unit)? = null
    private var onSuccess: (suspend () -> Unit)? = null


    inner class FlowBuilder<T>(flow: Flow<T>) {

        fun onHttpException(l: (suspend (errCode: Int) -> Unit)) {
            httpException = l
        }

        fun onEtcException(l: (suspend () -> Unit)) {
            etcException = l
        }
    }
}