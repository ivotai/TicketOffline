package com.unircorn.ticket.offline.cv

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.afollestad.materialdialogs.MaterialDialog
import com.unircorn.ticket.offline.R
import kotlinx.android.extensions.LayoutContainer

class CvingDialogView(context: Context) : FrameLayout(context), LayoutContainer {

    lateinit var dialog: MaterialDialog

    init {
        LayoutInflater.from(context).inflate(R.layout.dialog_cving, this, true)
    }

    override val containerView = this

}