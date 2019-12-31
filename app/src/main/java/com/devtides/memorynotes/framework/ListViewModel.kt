package com.devtides.memorynotes.framework

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.devtides.core.data.Note
import com.devtides.core.repository.NoteRepository
import com.devtides.core.usecase.AddNote
import com.devtides.core.usecase.GetAllNotes
import com.devtides.core.usecase.GetNote
import com.devtides.core.usecase.RemoveNote
import com.devtides.memorynotes.framework.di.ApplicationModule
import com.devtides.memorynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule((getApplication())))
            .build()
            .inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes() {
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }
            notes.postValue(noteList)
        }
    }

}