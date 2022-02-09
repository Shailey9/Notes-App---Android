package com.example.mynotes.room

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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

        saveBtn.setOnClickListener(){
             val title = findViewById<EditText>(R.id.addTitle).text.toString()
             val desc = findViewById<EditText>(R.id.addDescription).text.toString()
             if(NotesViewModel(this.application).insert(Notes(title, desc)).isCompleted){
                 Toast.makeText(this, "Note Added...", Toast.LENGTH_SHORT).show()
                 Intent(this, MainActivity::class.java).also {
                     startActivity(it)
                 }
             }else{
                 Toast.makeText(this, "Something went wrong...", Toast.LENGTH_SHORT).show()
             }
        }

    }
}