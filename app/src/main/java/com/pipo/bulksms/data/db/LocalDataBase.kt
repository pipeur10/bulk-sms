package com.pipo.bulksms.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.pipo.bible.data.converters.DateConverter
import com.pipo.bulksms.data.models.SmsJob


/**
 * Created by Philip on 04/12/2017.
 */
@Database(entities = [  SmsJob::class],
        version = 1,
        exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class LocalDataBase : RoomDatabase(){

    abstract fun getSmsJob(): SmsJobDao

    companion object {
        const val DB_NAME= "bulk_sms"
    }

}
