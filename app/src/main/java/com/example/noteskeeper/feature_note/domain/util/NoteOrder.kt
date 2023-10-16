package com.example.noteskeeper.feature_note.domain.util

sealed class NoteOrder(val orderType: OrderedType) {

    class Title(orderType:OrderedType) : NoteOrder(orderType)
    class Date(orderType:OrderedType) : NoteOrder(orderType)
    class Color(orderType:OrderedType) : NoteOrder(orderType)
}
