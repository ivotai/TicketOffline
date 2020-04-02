package com.unircorn.ticket.offline.base

interface UI {

    val layoutId: Int

    fun inject()

    fun initViews()

    fun bindIntent()

    fun registerEvent()

}