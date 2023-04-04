package com.aurosaswat.roompersistantlibraryimplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

// Database annotations accepts how many database we use so keep it in array ;_) and mark it as entities ;)
// When we make changes in an app then we need update the version of the app
@Database(entities = [Contact::class], version = 2)
@TypeConverters(Converters::class)
abstract class ContactDatabase: RoomDatabase() {
//    We need to inherit this abstract class with room Database ;_)
//    To link the Dao Interface we do the following below mentioned
    abstract fun contactDao():ContactDao

//    If we have multiple Dao we define then below as followed by above ;)

//    Now we make use of Singleton becoz one Application should have one instance of the Database ;)
    companion object{
//    aLL CHANGES THAT HAS BEEN ALTERED OR MADE CHANGES ARE PLACED INSIDE THE BELOW OCDE BLOCK
    val migration_1_2=object :Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE contact ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
        }

    }

    @Volatile
//    This annotation works like whenever anything gets updated to the variable
//    All the threads get to know that the value has been updated ;)





        private var INSTANCE : ContactDatabase?=null
//        Since it is decalred as private so inorder to access we need to make it exposed ;)
        fun getDatabase(context: Context):ContactDatabase{
            if (INSTANCE==null){
                synchronized(this){
                    INSTANCE= Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB")
                        .addMigrations(migration_1_2)
                        .build()
                }

                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }

}