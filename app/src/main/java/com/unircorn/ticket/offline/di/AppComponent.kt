package com.unircorn.ticket.offline.di

import com.unircorn.ticket.offline.Record
import com.unircorn.ticket.offline.api.SimpleApi
import dagger.Component
import io.objectbox.Box
import javax.inject.Singleton

@Singleton
@Component(modules = [ObjectBoxModule::class, NetworkModule::class, ApiModule::class])
interface AppComponent {

    fun recordBox(): Box<Record>

    fun api(): SimpleApi

}