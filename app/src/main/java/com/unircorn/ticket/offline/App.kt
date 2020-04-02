package com.unircorn.ticket.offline

import android.app.Application
import com.unircorn.ticket.offline.di.Holder

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Holder.init(this)
    }

}