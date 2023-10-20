package com.example.noteskeeper.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteskeeper.ui.theme.BabyBlue
import com.example.noteskeeper.ui.theme.LightGreen
import com.example.noteskeeper.ui.theme.RedOrange
import com.example.noteskeeper.ui.theme.RedPink
import com.example.noteskeeper.ui.theme.Violet

/*
I described the table structure.
 Table Structure ==>  id(col1) | title(col2) | content(col3) | timestamp(col4) | color(col5)
*/
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    /*
    The noteColors variable is declared inside the companion object because we want this variable to be
    associated with the class and not to the instance of class.

    It is similar to the static keyword in java which means that it will be relate to the class rather
    than to the instance of a class.
     */
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)