package com.devtides.core.usecase

import com.devtides.core.data.Note
import com.devtides.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.addNote(note)
}