package com.example.mynotes.repositories

import androidx.lifecycle.LiveData
import com.example.mynotes.entities.Notes
import com.example.mynotes.room.NotesDao

class NoteRepository{

     var notesDao : NotesDao? = null

     constructor(NtDao : NotesDao){
          this.notesDao = NtDao
     }

     fun insert(note : Notes) = notesDao!!.addNote(note)

     fun delete(note : Notes) = notesDao!!.deleteNote(note)

     fun deleteAll() = notesDao!!.deleteAll()

     fun getNotes() : LiveData<List<Notes>> = notesDao!!.getNotes()

}