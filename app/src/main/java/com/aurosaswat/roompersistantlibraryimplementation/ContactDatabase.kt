package com.aurosaswat.roompersistantlibraryimplementation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Database annotations accepts how many database we use so keep it in array ;_) and mark it as entities ;)
// When we make changes in an app then we need update the version of the app
@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase: RoomDatabase() {
//    We need to inherit this abstract class with room Database ;_)
//    To link the Dao Interface we do the following below mentioned
    abstract fun contactDao():ContactDao

//    If we have multiple Dao we define then below as followed by above ;)

//    Now we make use of Singleton becoz one Application should have one instance of the Database ;)
    companion object{
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
                        "contactDB").build()
                }

                return INSTANCE!!
            }else{
                return INSTANCE!!
            }
        }
    }

}