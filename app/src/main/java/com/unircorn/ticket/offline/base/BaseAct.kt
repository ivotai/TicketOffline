package com.unircorn.ticket.offline.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseAct : AppCompatActivity(), UI {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        inject()
        initViews()
        bindIntent()
        registerEvent()
    }

    override fun inject() {
    }

    override fun initViews() {
    }

    override fun bindIntent() {
    }

    override fun registerEvent() {
    }

}