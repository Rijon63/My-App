package com.example.noteapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.entity.QuizQuestion
import com.example.noteapp.data.repository.QuizRepository
import com.example.noteapp.room.QuizDatabase
import kotlinx.coroutines.launch

// ViewModel for managing QuizFragment data
class QuizViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: QuizRepository
    val allQuestions: LiveData<List<QuizQuestion>> // LiveData to hold list of all quiz questions

    init {
        // Initialize repository and LiveData
        val quizQuestionDao = QuizDatabase.getDatabase(application).quizQuestionDao()
        repository = QuizRepository(quizQuestionDao)
        allQuestions = repository.allQuestions // Initialize LiveData from repository
    }

    // Coroutine function to insert a quiz question
    fun insert(quizQuestion: QuizQuestion) = viewModelScope.launch {
        repository.insert(quizQuestion)
    }
}
