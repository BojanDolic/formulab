package com.aggressiveclick.formulab

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.aggressiveclick.formulab.dao.QuestionsDao
import kotlinx.coroutines.flow.Flow
import java.util.stream.Stream

class Repository(private val questionDao: QuestionsDao) {


    fun getQuestionCategories(): Flow<List<String>> {
        return questionDao.getCategories()
    }


}