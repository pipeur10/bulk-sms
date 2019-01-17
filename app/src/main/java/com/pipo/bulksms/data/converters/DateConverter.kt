package com.pipo.bible.data.converters

import android.arch.persistence.room.TypeConverter


import java.util.Date

/**
 * Author: Philip
 * Date: 09/04/2018 at 2:42 PM
 */
class DateConverter {


    companion object {
        @TypeConverter @JvmStatic
        fun toDate(time: Long): Date {
            return Date(time)
        }

        @TypeConverter @JvmStatic
        fun toTimestamp(date: Date): Long {
            return date.time
        }
    }

}
