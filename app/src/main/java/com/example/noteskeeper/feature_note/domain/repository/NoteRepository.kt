package com.example.noteskeeper.feature_note.domain.repository

import com.example.noteskeeper.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

/*
--1.The repository is used to extract the data from the data sources.
--2. All the logic of extracting data from which resource at which time is done by the repository.

    All the functions are initialized in the domain layer repository but they are
    implemented in the data layer repository package.
 */
interface NoteRepository {

    fun getNotes() : Flow<List<Note>>

    suspend fun getNoteById(id : Int) : Note?

    suspend fun insertNote(note : Note)

    suspend fun deleteNote(note : Note)
}