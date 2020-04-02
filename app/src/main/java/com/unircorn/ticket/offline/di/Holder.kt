package com.unircorn.ticket.offline.di

import android.app.Application

object Holder {

    lateinit var appComponent: AppComponent

    fun init(application: Application) {
        val objectBoxModule = ObjectBoxModule(context = application)
        appComponent = DaggerAppComponent.builder()
            .objectBoxModule(objectBoxModule).build()
    }

}