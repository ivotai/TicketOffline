package com.unircorn.ticket.offline

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.unircorn.ticket.offline.di.Holder

class App : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        Holder.init(this)
    }

}