package com.aggressiveclick.formulab.ui.fragments

import android.app.Application
import androidx.lifecycle.*
import com.aggressiveclick.formulab.Repository
import com.aggressiveclick.formulab.database.QuestionsDatabase
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch

public class SelectTestViewModel(app: Application) : AndroidViewModel(app) {

    var repository: Repository

    init {
        val database = QuestionsDatabase.getDatabaseInstance(app.applicationContext)

        val dao = database.questionsDao()
        repository = Repository(dao)

    }

    fun getCategories(): LiveData<List<String>> {
        return repository.getQuestionCategories().asLiveData()
    }


}