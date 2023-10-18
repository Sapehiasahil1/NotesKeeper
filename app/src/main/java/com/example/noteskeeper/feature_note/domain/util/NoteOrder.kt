package com.example.noteskeeper.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderedType) {

    class Title(orderType:OrderedType) : NoteOrder(orderType)
    class Date(orderType:OrderedType) : NoteOrder(orderType)
    class Color(orderType:OrderedType) : NoteOrder(orderType)

    fun copy(orderedType: OrderedType) : NoteOrder {
        return when(this) {
            is Title -> Title(orderedType)
            is Date -> Date(orderedType)
            is Color -> Color(orderedType)
        }
    }
}
