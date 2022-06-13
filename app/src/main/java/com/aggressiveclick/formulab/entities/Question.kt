package com.aggressiveclick.formulab.entities

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pitanja")
data class Question(
    @PrimaryKey val id: Int,

    @ColumnInfo(name = "pitanje")
    val questionText: String = "",

    @ColumnInfo(name = "odgovori")
    val answers: ArrayList<String> = arrayListOf(),

    @ColumnInfo(name = "tacni_odgovori")
    val correctAnswers: ArrayList<String> = arrayListOf(),

    @ColumnInfo(name = "vise_odgovora")
    val multipleAnswers: Boolean = false,

    @ColumnInfo(name = "slika")
    val pictureName: String = "",

    @ColumnInfo(name = "kategorija")
    @NonNull
    val category: String = "",

    @ColumnInfo(name = "podkategorija")
    @NonNull
    val subCategory: String = "",
)
