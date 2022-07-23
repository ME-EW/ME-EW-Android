package com.kangmin.meew.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import retrofit2.HttpException

class FlowApi() {
    private var httpException: (suspend (errCode: Int) -> Unit)? = null
    private var etcException: (suspend () -> Unit)? = null
    private var onSuccess: (suspend () -> Unit)? = null


    inner class FlowBuilder<T>(private val flowItem: Flow<T>) {

        fun onSuccess(l: suspend () -> Unit) {
            onSuccess = l
        }

        fun onHttpException(l: (suspend (errCode: Int) -> Unit)) {
            httpException = l
        }

        fun onEtcException(l: (suspend () -> Unit)) {
            etcException = l
        }

        suspend fun build() {
            flowItem.catch {
                if (it is HttpException) {
                    httpException
                } else {
                    etcException
                }
            }.collect {
                onSuccess
            }
        }
    }
}