package com.kangmin.meew.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import retrofit2.HttpException

class FlowApi<T>(private val flowItem: Flow<T>) {
    private var httpException: (suspend (errCode: Int) -> Unit)? = null
    private var etcException: (suspend () -> Unit)? = null
    private var onSuccess: (suspend (T) -> Unit)? = null

    inner class FlowBuilder {

        fun onSuccess(l: suspend (T) -> Unit): FlowBuilder {
            onSuccess = l
            return this
        }

        fun onHttpException(l: (suspend (errCode: Int) -> Unit)): FlowBuilder {
            httpException = l
            return this
        }

        fun onEtcException(l: (suspend () -> Unit)): FlowBuilder {
            etcException = l
            return  this
        }

        suspend fun build() {
            flowItem.catch {
                if (it is HttpException) {
                    httpException
                } else {
                    etcException
                }
            }.collectLatest {
                onSuccess
            }
        }
    }
}