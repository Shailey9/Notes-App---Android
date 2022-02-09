package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.entities.Notes
import com.example.mynotes.room.AddNotes
import com.example.mynotes.room.NotesDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NotesAdapter.OnItemClickListener {

    var noteViewModel : NotesViewModel? = null
    var recyclerView : RecyclerView? = null
    var arr : List<Notes>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NotesDatabase.getDatabase(this)

        recyclerView = findViewById(R.id.recyclerView)
        noteViewModel = NotesViewModel(this.application)


        noteViewModel?.let {
             it.getNotes().observe(this, Observer {
                 arr = it
                 setAdapter()
             })
        }

        addBtn.setOnClickListener(){
            Intent(this, AddNotes::class.java).also {
                startActivity(it)
            }
        }
    }

    fun setAdapter(){
        val adapter = NotesAdapter(arr!!, noteViewModel!!)
        adapter.setOnItemClickListener(this)
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.itemAnimator = DefaultItemAnimator()
    }

    override fun onItemClick(position: Int) {
        Intent(this, AddNotes::class.java).also {
            it.putExtra("NoteId", arr!!.get(position).id)
            it.putExtra("NoteTitle", arr!!.get(position).title)
            it.putExtra("NoteDescription", arr!!.get(position).description)
            startActivity(it)
        }
    }
}