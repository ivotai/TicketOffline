package com.unircorn.ticket.offline.di

import android.app.Application
import com.unircorn.ticket.offline.DaggerAppComponent

object Holder {

    lateinit var appComponent: AppComponent

    fun init(application: Application) {
        val objectBoxModule =
            ObjectBoxModule(context = application)
        appComponent = DaggerAppComponent.builder()
            .objectBoxModule(objectBoxModule).build()
    }

}