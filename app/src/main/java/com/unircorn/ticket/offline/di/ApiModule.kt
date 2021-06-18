package com.unircorn.ticket.offline.di

import com.unircorn.ticket.offline.api.SimpleApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun simpleApi(retrofit: Retrofit): SimpleApi = retrofit.create(SimpleApi::class.java)

}