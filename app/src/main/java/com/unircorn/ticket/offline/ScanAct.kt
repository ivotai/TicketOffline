package com.unircorn.ticket.offline

import android.annotation.SuppressLint
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.DeviceUtils
import com.jakewharton.rxbinding3.view.clicks
import com.unircorn.ticket.offline.base.BaseAct
import com.unircorn.ticket.offline.base.BaseScanAct
import kotlinx.android.synthetic.main.act_scan.*
import org.joda.time.DateTime

class ScanAct : BaseScanAct() {

    @SuppressLint("SetTextI18n")
    override fun initViews() {
        tvVersionName.text = "程序版本：${AppUtils.getAppVersionName()}"
        tvLoginTime.text = "登录时间：${DateTime().toString(displayDateFormat)}"
        tvAndroidId.text = "设备 ID：${DeviceUtils.getAndroidID()}"
    }

    override fun bindIntent() {
        super.bindIntent()
        llCheckin.clicks().subscribe { scanTicketCode() }
    }

    override val layoutId = R.layout.act_scan

}
