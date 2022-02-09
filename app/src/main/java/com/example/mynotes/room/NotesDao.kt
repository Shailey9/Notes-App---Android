package com.example.mynotes.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mynotes.entities.Notes

@Dao
interface NotesDao {

    @Insert
    fun addNote(note : Notes)

    @Delete
    fun deleteNote(note : Notes)

    @Query("Delete from Notes")
    fun deleteAll()

    @Query("Select * from Notes")
    fun getNotes() : LiveData<List<Notes>>

}