package com.unircorn.ticket.offline.model

import com.unircorn.ticket.offline.Record

 class RecordForUpload( record: Record){
     val scanTime = record.scanTime.time
     val ticketCode = record.ticketCode
 }
