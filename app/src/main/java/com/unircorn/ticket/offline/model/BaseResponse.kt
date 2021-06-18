package com.unircorn.ticket.offline.model

import com.blankj.utilcode.util.ToastUtils

open class BaseResponse<T>(
    val message: String,
    val success: Boolean,
    val data: T
) {
    val failed: Boolean
        get() {
            val failed = !success
            if (failed) ToastUtils.showShort(message)
            return failed
        }
}