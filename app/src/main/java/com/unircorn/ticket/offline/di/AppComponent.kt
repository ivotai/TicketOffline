package com.unircorn.ticket.offline.di

import com.unircorn.ticket.offline.Record
import dagger.Component
import io.objectbox.Box
import javax.inject.Singleton

@Singleton
@Component(modules = [ObjectBoxModule::class])
interface AppComponent {

    fun recordBox(): Box<Record>

}