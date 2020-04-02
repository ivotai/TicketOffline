package com.unircorn.ticket.offline

import android.annotation.SuppressLint
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.DeviceUtils
import com.unircorn.ticket.offline.base.BaseAct
import kotlinx.android.synthetic.main.act_scan.*
import org.joda.time.DateTime

class ScanAct : BaseAct() {

    @SuppressLint("SetTextI18n")
    override fun initViews() {
        tvVersionName.text = "程序版本：${AppUtils.getAppVersionName()}"
        tvLoginTime.text = "登录时间：${DateTime().toString(displayDateFormat)}"
        tvAndroidId.text = "设备 ID：${DeviceUtils.getAndroidID()}"
    }

    override val layoutId = R.layout.act_scan

}
