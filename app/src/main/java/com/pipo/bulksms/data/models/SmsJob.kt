package com.pipo.bulksms.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:13 PM
 */
@Entity(tableName = "sms_job" )
data class SmsJob(@PrimaryKey(autoGenerate = true) val id: Long,
                  val to: String,
                  val message: String,
                  val total: Int,
                  val sent: Int,
                  val cancel: Boolean,
                  val completed: Boolean,
                  val startDate: Date,
                  val lastUpdated: Date,
                  val created: Date)