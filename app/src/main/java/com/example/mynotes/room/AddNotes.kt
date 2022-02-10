package com.example.mynotes.room

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mynotes.MainActivity
import com.example.mynotes.NotesViewModel
import com.example.mynotes.R
import com.example.mynotes.entities.Notes
import kotlinx.android.synthetic.main.add_notes.*

class AddNotes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_notes)

        val intt = intent
        val NoteId = intt.getIntExtra("NoteId", 0)
        val NoteTitle = intt.getStringExtra("NoteTitle")
        val NoteDescription = intt.getStringExtra("NoteDescription")

        addTitle.setText(NoteTitle)
        addDescription.setText(NoteDescription)

        saveBtn.setOnClickListener(){
            if( addTitle.text.toString().trim().length == 0 && addDescription.text.toString().trim().length == 0 ){
                Toast.makeText(this, "Empty Note Discarded", Toast.LENGTH_SHORT).show()
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                }
                return@setOnClickListener
            }
            if(NoteId!=0) {
                val note = Notes(addTitle.text.toString(), addDescription.text.toString())
                note.id = NoteId
                NotesViewModel(this.application).update(note)
                Toast.makeText(this, "Note Added...", Toast.LENGTH_SHORT).show()
            }else{
                NotesViewModel(this.application).insert(Notes(addTitle.text.toString(), addDescription.text.toString()))
                Toast.makeText(this, "Note Added...", Toast.LENGTH_SHORT).show()
            }
            Intent(this, MainActivity::class.java).also {
               startActivity(it)
            }
        }
    }
}