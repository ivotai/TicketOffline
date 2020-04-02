package com.unircorn.ticket.offline

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.util.*

@Entity
data class Record(
    @Id
    var id: Long = 0,
    var ticketCode: String,
    var scanTime: Date = Date()
)