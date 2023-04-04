package com.aurosaswat.roompersistantlibraryimplementation

import androidx.room.TypeConverter
import java.util.*

class Converters {
//    Make sure you go to your Database class and mention TypeConverters annotation ;)
    @TypeConverter
    fun fromDatetoLong(value: Date):Long{
//        Since DB cannot store Date values so we covert it into long ;)
        return value.time
    }

    @TypeConverter
    fun fromlongtoDate(value:Long):Date{
        return Date(value)
    }
}