package com.aurosaswat.roompersistantlibraryimplementation

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity Class
@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val phone:String
)