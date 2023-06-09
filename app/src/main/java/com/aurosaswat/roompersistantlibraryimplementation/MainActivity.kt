package com.aurosaswat.roompersistantlibraryimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

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



        database=ContactDatabase.getDatabase(this)

        GlobalScope.launch {
            database.contactDao().insertContact(Contact(0,"Auro","8249696287",Date(),1))
        }

        /**
         *
         * Type Converters
         * SQLITE SUPPORTS ONLY THE FOLLOWING DATATYPES
         * 1. NULL
         * 2. INTEGER
         * 3. REAL
         * 4. TEXT
         * 5. BLOB
         *
         * APART FROM THAT IF WE WANT TO USE ANY OTHER THAN WE NEED
         * TO USE TYPE CONVERTERS FOR EX: DATE
         *
         *
         * NOTE CONVERTER WILL ONLY BE CALLED WHEN WE SAVE DATA OR
         * WHEN WE WANT RTO FETCH DATA CONVERTER WILL BE CALLED ;)
         *
         * */









    }

    fun getData(view: View){
//        We will be using observe method becoz the return type of getContact is LiveData
//        The observer{} will observe that whenever we will have changes in our database or new method is called then this method will be automatically called ;
        database.contactDao().getContact().observe(this, Observer {
            Log.d("MainActiauro",it.toString())
//            So in this way we use getMethods ;)
        })
    }
}