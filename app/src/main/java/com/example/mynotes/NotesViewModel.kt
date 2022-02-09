package com.example.mynotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.mynotes.entities.Notes
import com.example.mynotes.repositories.NoteRepository
import com.example.mynotes.room.NotesDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel : AndroidViewModel {

    var notesRepository : NoteRepository? = null

    constructor(application: Application) : super(application){
        notesRepository = NoteRepository(NotesDatabase.getDatabase(application).getDao())
    }

    fun insert(note : Notes ) = CoroutineScope(Dispatchers.IO).launch {
        notesRepository!!.insert(note)
    }

    fun delete( note : Notes ) = CoroutineScope(Dispatchers.IO).launch {
        notesRepository!!.delete(note)
    }

    fun deleteAll() = CoroutineScope(Dispatchers.IO).launch {
        notesRepository!!.deleteAll()
    }

    fun update(note : Notes) = CoroutineScope(Dispatchers.IO).launch {
        notesRepository!!.update(note)
    }

    fun getNotes() : LiveData<List<Notes>> = notesRepository!!.getNotes()

}