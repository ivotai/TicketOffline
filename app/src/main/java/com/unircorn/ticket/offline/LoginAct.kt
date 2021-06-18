package com.unircorn.ticket.offline

import com.blankj.utilcode.util.ToastUtils
import com.unircorn.ticket.offline.base.BaseAct
import com.unircorn.ticket.offline.di.Holder
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.act_login.*


class LoginAct : BaseAct() {

    override fun initViews() {
    }

    override fun bindIntent() {
        rtvLogin.safeClicks().subscribe { loginX() }
    }

    // login 的加强版
    private fun loginX() {
        fun login() {
            val mask = DialogHelper.showMask(this)
            Holder.appComponent.api().login(etUsername.trimText(), etPassword.trimText())
                .observeOnMain(this)
                .subscribeBy(
                    onSuccess = {
                        mask.dismiss()
                        if (it.failed) return@subscribeBy
                        Global.loginResponse = it
                    },
                    onError = {
                        mask.dismiss()
                    }
                )
        }

        if (etUsername.isEmpty()) {
            ToastUtils.showShort("工号不能为空")
            return
        }
        if (etPassword.isEmpty()) {
            ToastUtils.showShort("密码不能为空")
            return
        }
        login()
    }

    override val layoutId = R.layout.act_login

}