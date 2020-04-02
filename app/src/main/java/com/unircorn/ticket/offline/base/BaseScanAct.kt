package com.unircorn.ticket.offline.base

import android.content.Intent
import com.blankj.utilcode.util.ToastUtils
import com.unircorn.ticket.offline.Record
import com.unircorn.ticket.offline.SunmiScannerHelper
import com.unircorn.ticket.offline.cv.DialogHelper
import com.unircorn.ticket.offline.di.Holder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

abstract class BaseScanAct : BaseAct() {

    override fun bindIntent() {
        sunmiScannerHelper = SunmiScannerHelper(this, object : SunmiScannerHelper.ScanListener {
            override fun onScanResult(result: String) {
                putRecord(ticketCode = result)
            }
        })
    }

    protected fun scanTicketCode() {
        if (sunmiScannerHelper.scannerModel in listOf(103, 106, 107)) {
            DialogHelper.showCvingDialog(this)
            sunmiScannerHelper.scan()
        } else
            startSunmiQrcodeScanner()
    }

    private fun startSunmiQrcodeScanner() {
        val intent = Intent("com.summi.scan")
        intent.setPackage("com.sunmi.sunmiqrcodescanner")
        startActivityForResult(intent, qrcodeRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == qrcodeRequestCode) {
            if (data == null) {
                ToastUtils.showShort("已取消")
            } else {
                val bundle = data.extras
                val result = bundle!!.getSerializable("data") as ArrayList<*>
                val hashMap = result[0] as HashMap<*, *>
                val value = hashMap["VALUE"] as String
                putRecord(ticketCode = value)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun putRecord(ticketCode: String) {
        val recordBox = Holder.appComponent.recordBox()
        val record = Record(ticketCode = ticketCode)
        val id = recordBox.put(record)
        if (id != 0L)
            ToastUtils.showShort("扫码已保存")
    }

    override fun onDestroy() {
        sunmiScannerHelper.release()
        super.onDestroy()
    }

    private lateinit var sunmiScannerHelper: SunmiScannerHelper

    private val qrcodeRequestCode = 1

}