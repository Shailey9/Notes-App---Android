package com.example.mynotes

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.entities.Notes
import com.example.mynotes.room.NotesDatabase

class NotesAdapter( private var arrlist : List<Notes>, private var notesViewModel : NotesViewModel ) : RecyclerView.Adapter<NotesAdapter.MyViewHolder>() {

    val arr : List<Notes> = arrlist

    class MyViewHolder : RecyclerView.ViewHolder{
          var txtTitle : TextView? = null
          var txtDescription : TextView? = null
          var deleteBtn : ImageButton? = null
         constructor(view : View) : super(view){
             txtTitle = view.findViewById(R.id.title)
             txtDescription = view.findViewById(R.id.description)
             deleteBtn = view.findViewById(R.id.deleteBtn)
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.notes_list, parent, false)
        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txtTitle!!.text = arr.get(position).title
        holder.txtDescription!!.text = arr.get(position).description
        holder.deleteBtn!!.setOnClickListener(){
             notesViewModel.delete(arr.get(holder.adapterPosition))
        }
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}