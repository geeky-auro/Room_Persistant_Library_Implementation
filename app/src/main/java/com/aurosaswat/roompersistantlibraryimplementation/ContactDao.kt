package com.aurosaswat.roompersistantlibraryimplementation

import androidx.lifecycle.LiveData
import androidx.room.*


// Dao ;0

@Dao
interface ContactDao {
    @Insert
   suspend fun insertContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact:Contact)

//    It will provide list of Contacts
//  Also we will use live data on it

    /**
     * When ever Room observes that the return type is sorrounded with live data then it starts
     * executing in background thread ;)
     * So, we dont need to define suspend and it will automatically execute in background thread ;)
     *
     * */
    @Query("SELECT * FROM contact")
    fun getContact() : LiveData<List<Contact>>




}