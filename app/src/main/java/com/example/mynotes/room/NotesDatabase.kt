package com.example.mynotes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.entities.Notes

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun getDao() : NotesDao

    companion object{

        @Volatile
        var instance : NotesDatabase? = null
        fun getDatabase(context: Context) : NotesDatabase {
            if(instance !=null){
                return instance!!
            }
            synchronized(this){
                instance = Room.databaseBuilder(context.applicationContext,
                    NotesDatabase::class.java,
                    "Notes_Database"
                ).build()
            }
            return instance!!
        }
    }

}