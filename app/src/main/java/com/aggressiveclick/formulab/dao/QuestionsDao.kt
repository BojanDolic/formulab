package com.aggressiveclick.formulab.dao

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestionsDao {

    @Query("SELECT DISTINCT kategorija FROM pitanja")
    fun getCategories(): Flow<List<String>>


}