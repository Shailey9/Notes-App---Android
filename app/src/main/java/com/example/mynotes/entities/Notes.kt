package com.example.mynotes.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Notes" )
data class Notes(
    val title : String,
    val description : String) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}