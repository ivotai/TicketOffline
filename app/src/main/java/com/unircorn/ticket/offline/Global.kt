package com.unircorn.ticket.offline

import com.unircorn.ticket.offline.model.LoginResponse

object Global {

    val session: String get() = loginResponse.session
    val token: String get() = loginResponse.loginToken

    lateinit var loginResponse: LoginResponse

}