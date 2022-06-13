package com.aggressiveclick.formulab.util

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun convertFromArrayToString(list: ArrayList<String>): String {
        var stringList = ""
        for(item in list) {
            stringList += "$item;"
        }
        return stringList
    }

    @TypeConverter
    fun convertStringToArray(string: String): ArrayList<String> {
        val list = string.split(";")
        var array = arrayListOf<String>()

        for(item in list) {
            array.add(item.trim())
        }
        return array
    }

}