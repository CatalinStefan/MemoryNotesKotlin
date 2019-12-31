package com.devtides.memorynotes.framework.di

import com.devtides.core.repository.NoteRepository
import com.devtides.core.usecase.*
import com.devtides.memorynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {
    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}