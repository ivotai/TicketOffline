package com.unircorn.ticket.offline.di

import android.content.Context
import com.unircorn.ticket.offline.MyObjectBox
import com.unircorn.ticket.offline.Record
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser
import io.objectbox.kotlin.boxFor
import javax.inject.Singleton

@Module
class ObjectBoxModule(private val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Singleton
    @Provides
    fun provideBoxStore(context: Context): BoxStore {
        val applicationContext = context.applicationContext
        val boxStore = MyObjectBox.builder()
            .androidContext(applicationContext)
            .build()
        AndroidObjectBrowser(boxStore).start(applicationContext)
        return boxStore
    }

    @Provides
    fun provideRecordBox(boxStore: BoxStore): Box<Record> = boxStore.boxFor()

}