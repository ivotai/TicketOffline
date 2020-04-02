package com.unircorn.ticket.offline.cv

import android.app.Activity
import android.content.Context
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

object DialogHelper {

    fun showCvingDialog(context: Context) {
        val view = CvingDialogView(context)
        view.dialog = createDialog(
            context,
            view
        )
        view.dialog.show()
        Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe {
            val a = context as Activity
            if (!a.isDestroyed)
                view.dialog.dismiss()
        }
    }

    private fun createDialog(context: Context, view: View): MaterialDialog {
        return MaterialDialog(context)
            .customView(view = view, noVerticalPadding = true)
            .cancelOnTouchOutside(true)
            .cornerRadius(8f)
    }

}