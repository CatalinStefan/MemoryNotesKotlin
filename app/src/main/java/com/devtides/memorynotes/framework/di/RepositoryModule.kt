package com.devtides.memorynotes.framework.di

import android.app.Application
import com.devtides.core.repository.NoteRepository
import com.devtides.memorynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}