package com.aggressiveclick.formulab.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aggressiveclick.formulab.dao.QuestionsDao
import com.aggressiveclick.formulab.entities.Question
import com.aggressiveclick.formulab.util.Converters


@Database(entities = [Question::class], version = 2)
@TypeConverters(value = [Converters::class])
abstract class QuestionsDatabase : RoomDatabase() {

    abstract fun questionsDao(): QuestionsDao

    companion object {

        @Volatile
        private var INSTANCE: QuestionsDatabase? = null

        fun getDatabaseInstance(context: Context): QuestionsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionsDatabase::class.java,
                    "formulab_baza")
                    .allowMainThreadQueries()
                    .createFromAsset("formulab_baza.db")
                    .build()

                INSTANCE = instance
                instance
            }
        }



    }


}