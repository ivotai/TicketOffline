package com.unircorn.ticket.offline

import com.unircorn.ticket.offline.di.Holder
import okhttp3.Interceptor
import okhttp3.Response

object NetworkHelper {

    fun proceedRequestWithNewSession(chain: Interceptor.Chain): Response {
        // session 过期时使用 token 登录，获取新的 session 和 token。
        api.loginSilently().execute().body().let { Global.loginResponse = it!! }
        return proceedRequestWithSession(chain)
    }

    fun proceedRequestWithSession(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .removeHeader(Key.Cookie)
            .addHeader(Key.Cookie, "${Key.SESSION}=${Global.session}")
            .build()
            .let { chain.proceed(it) }
    }

    fun closeConnection(chain: Interceptor.Chain): Response {
        return chain.request().newBuilder()
            .removeHeader("Connection")
            .addHeader("Connection", "close")
            .build()
            .let { chain.proceed(it) }
    }

    private val api by lazy { Holder.appComponent.api() }

}