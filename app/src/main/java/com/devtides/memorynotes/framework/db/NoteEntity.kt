package com.devtides.memorynotes.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.devtides.core.data.Note

@Entity(tableName = "note")
data class NoteEntity(
    val title: String,
    val content: String,

    @ColumnInfo(name = "creation_date")
    val creationTime: Long,

    @ColumnInfo(name = "update_time")
    val updateTime: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L
) {
    companion object {
        fun fromNote(note: Note) = NoteEntity(note.title, note.content, note.creationTime, note.updateTime, note.id)
    }

    fun toNote() = Note(title, content, creationTime, updateTime, id)
}