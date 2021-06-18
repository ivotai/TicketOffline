package com.unircorn.ticket.offline.api

import com.blankj.utilcode.util.DeviceUtils
import com.unircorn.ticket.offline.Global
import com.unircorn.ticket.offline.model.LoginResponse
import io.reactivex.Observable
import io.reactivex.Single
import org.joda.time.DateTime
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface SimpleApi {

    @GET("login/account")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Single<LoginResponse>

    @GET("login/silence")
    fun loginSilently(@Query("token") token: String = Global.token): Call<LoginResponse>

}