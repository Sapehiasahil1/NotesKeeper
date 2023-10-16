package com.example.noteskeeper.feature_note.domain.util

sealed class OrderedType {
    object Ascending : OrderedType()
    object Descending : OrderedType()
}
