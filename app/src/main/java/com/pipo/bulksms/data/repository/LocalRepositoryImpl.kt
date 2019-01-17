package com.pipo.bulksms.data.repository

import android.arch.lifecycle.LiveData
import com.pipo.bulksms.data.db.LocalDataBase
import com.pipo.bulksms.data.models.SmsJob

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:31 PM
 */
class LocalRepositoryImpl(localDataBase: LocalDataBase): LocalRepository {

    private val smsJobDao= localDataBase.getSmsJob()

    override fun upsertSmsJob(obj: SmsJob): Long = smsJobDao.upsert(obj)

    override fun deleteSmsJob(obj: SmsJob) = smsJobDao.delete(obj)

    override fun deleteSmsJob(objs: List<SmsJob>) = smsJobDao.delete(objs)

    override fun getAllSmsJob(): LiveData<List<SmsJob>> = smsJobDao.getAll()

    override fun getOneSmsJob(id: Long): LiveData<SmsJob> = smsJobDao.getOne(id)

    override fun getOneSmsJobSync(id: Long): SmsJob = smsJobDao.getOneSync(id)

    override fun incrementSmsSentCount(id: Long) = smsJobDao.incrementSentCount(id)





}