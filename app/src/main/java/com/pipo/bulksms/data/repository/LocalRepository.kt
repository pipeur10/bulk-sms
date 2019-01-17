package com.pipo.bulksms.data.repository

import android.arch.lifecycle.LiveData
import com.pipo.bulksms.data.models.SmsJob

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:10 PM
 */
interface LocalRepository {

    fun upsertSmsJob(obj: SmsJob): Long

    fun deleteSmsJob(obj: SmsJob)

    fun deleteSmsJob(objs: List<SmsJob>)

    fun getAllSmsJob(): LiveData<List<SmsJob>>

    fun getOneSmsJob(id: Long): LiveData<SmsJob>

    fun getOneSmsJobSync(id: Long): SmsJob

    fun incrementSmsSentCount(id: Long)
}