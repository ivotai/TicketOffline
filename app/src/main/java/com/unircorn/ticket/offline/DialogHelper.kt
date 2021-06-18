package com.unircorn.ticket.offline

import android.content.Context
import android.view.View
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.kaopiz.kprogresshud.KProgressHUD

object DialogHelper {

    fun showMask(context: Context): KProgressHUD {
        return KProgressHUD.create(context)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setCancellable(true)
            .setDimAmount(0.5f)
            .show()
    }

    private fun createDialog(context: Context, view: View): MaterialDialog {
        return MaterialDialog(context)
            .customView(view = view, noVerticalPadding = true)
            .cancelOnTouchOutside(true)
            .cornerRadius(8f)
    }

}