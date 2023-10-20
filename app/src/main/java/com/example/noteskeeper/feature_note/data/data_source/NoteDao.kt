package com.example.noteskeeper.feature_note.data.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.noteskeeper.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/*
This is an interface in which we describe all the methods that are used to access the database.
 */
@Dao
interface NoteDao {

    @Query("SELECT * FROM Note")
    fun getNotes() : Flow<List<Note>>
    /*
    we have kept the func of return type Flow<List<Note>> because we wanted it to be asynchronous, so that
    it does not block the main thread and can run in background.
     */

    @Query("SELECT * FROM Note WHERE id = :id")
    suspend fun getNoteById(id: Int) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}