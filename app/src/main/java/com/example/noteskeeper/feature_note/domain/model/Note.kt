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
 Table Strucutre ==>  id(col1) | title(col2) | content(col3) | timestamp(col4) | color(col5)
*/
@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    // It is similar to static keyword in JAVA which means it will load as the class loads.
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
