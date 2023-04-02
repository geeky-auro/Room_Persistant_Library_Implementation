package com.aurosaswat.roompersistantlibraryimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
//    We define the database here
    lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Entity
         *Dao
         * Database Declaration
         *
         * */

//        Initializing the database
//        Here contactDB is the name of the Database ;)

//        Not this is not a good approach generally we make use of singleton ;)
        database=Room.databaseBuilder(applicationContext,
        ContactDatabase::class.java,
        "contactDB").build()

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Auro","8249696287"))
        }






    }
}