package com.wasimsirschaudharyco.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import java.net.SocketTimeoutException

class  TimeoutInterceptorImpl : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (isConnectionTimedOut(chain))
            throw SocketTimeoutException()
        return chain.proceed(chain.request())
    }

    private fun isConnectionTimedOut(chain: Interceptor.Chain): Boolean {
        try {
            val response = chain.proceed(chain.request())
            val content = response.toString()
            response.close()
            Log.d("Retrofit", "isConnectionTimedOut() => $content")
        } catch (e: SocketTimeoutException) {
            return true
        }
        return false
    }
}