package com.forecastapp.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class AppTypeConverters {

    var gson = Gson()

    @TypeConverter
    fun getStringToList(data: String?): List<String?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object : TypeToken<List<String?>?>() {}.getType()
        return gson.fromJson<List<String?>>(data, listType)
    }

    @TypeConverter
    fun getListToString(someObjects: List<String?>?): String? {
        return gson.toJson(someObjects)
    }
}