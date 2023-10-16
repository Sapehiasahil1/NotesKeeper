package com.example.noteskeeper.feature_note.data.repository

import com.example.noteskeeper.feature_note.data.data_source.NoteDao
import com.example.noteskeeper.feature_note.domain.model.Note
import com.example.noteskeeper.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

/*
 It is the implementation of the functions that were initialized in the domain layer repository.

 Here we have taken the dao object as a parameter so we can access the database
 */
class NoteRepositoryImpl(
    private val dao : NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}