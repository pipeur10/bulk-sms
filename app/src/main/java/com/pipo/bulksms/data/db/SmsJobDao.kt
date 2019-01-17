package com.pipo.bulksms.data.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.pipo.bulksms.data.models.SmsJob

/**
 * Author: Philip
 * Date: 12/09/2018 at 3:13 PM
 */
@Dao
interface SmsJobDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(obj: SmsJob): Long

    @Delete
    fun delete(obj: SmsJob)

    @Delete
    fun delete(obj: List<SmsJob>)

    @Query("SELECT * FROM sms_job")
    fun getAll(): LiveData<List<SmsJob>>

    @Query("SELECT * FROM sms_job WHERE id=:id")
    fun getOne(id: Long): LiveData<SmsJob>

    @Query("SELECT * FROM sms_job WHERE id=:id")
    fun getOneSync(id: Long): SmsJob

    @Query("UPDATE sms_job SET sent= sent+1 WHERE id=:id")
    fun incrementSentCount(id: Long)

}