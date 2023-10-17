package com.example.noteskeeper.feature_note.presentation.notes

import com.example.noteskeeper.feature_note.domain.model.Note
import com.example.noteskeeper.feature_note.domain.util.NoteOrder

// This sealed class here is made to mention all the user events that user can do while interacting with app.
// Always remember that " we have to mention all the subclasses in the same sealed class"
// Here the suclasses are finite and everyclass is not allowed to be the subclass.
sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note) : NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
