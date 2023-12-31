package com.example.noteskeeper.feature_note.domain.use_case

import com.example.noteskeeper.feature_note.domain.model.Note
import com.example.noteskeeper.feature_note.domain.repository.NoteRepository
import com.example.noteskeeper.feature_note.domain.util.NoteOrder
import com.example.noteskeeper.feature_note.domain.util.OrderedType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/*
Use-case should have only one public function.
 */
class GetNotes(
    private val repository : NoteRepository
) {

    operator fun invoke(
        noteOrder : NoteOrder= NoteOrder.Date(OrderedType.Descending)
    ) : Flow<List<Note>>{
        return repository.getNotes().map {notes ->
            when(noteOrder.orderType) {
                is OrderedType.Ascending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderedType.Descending -> {
                    when(noteOrder) {
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}