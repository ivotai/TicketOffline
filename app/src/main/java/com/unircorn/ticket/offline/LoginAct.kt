package com.unircorn.ticket.offline

import com.blankj.utilcode.util.ToastUtils
import com.unircorn.ticket.offline.base.BaseAct
import com.unircorn.ticket.offline.di.Holder
import com.unircorn.ticket.offline.model.OfflineCheckinParam
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
                        offlineCheckin()
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

    private fun offlineCheckin() {
        val mask = DialogHelper.showMask(this)
        val query = Holder.appComponent.recordBox().query().build()
        val recordList = query.find()
        query.close()
        Holder.appComponent.api().offlineCheckin(OfflineCheckinParam(recordList = recordList))
            .observeOnMain(this)
            .subscribeBy(
                onSuccess = {
                    mask.dismiss()
                    if (it.failed) {
                        ToastUtils.showShort("上传离线记录失败")
                        return@subscribeBy
                    }
                    ToastUtils.showShort("上传离线记录成功")
                    Holder.appComponent.recordBox().removeAll()
                },
                onError = {
                    mask.dismiss()
                    ToastUtils.showShort("上传离线记录失败")
                }
            )
    }

    override val layoutId = R.layout.act_login

}