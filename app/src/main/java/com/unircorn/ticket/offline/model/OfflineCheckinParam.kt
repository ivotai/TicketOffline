package com.unircorn.ticket.offline.model

import com.blankj.utilcode.util.DeviceUtils
import com.unircorn.ticket.offline.Record

data class OfflineCheckinParam(
    val recordList: List<Record>,
    val gateTag: String = DeviceUtils.getAndroidID(),
    val detailList: List<RecordForUpload> = recordList.map { RecordForUpload(it) }
)