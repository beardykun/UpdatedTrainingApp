package com.example.updatedtrainingapp.utils

import com.example.updatedtrainingapp.application.MySharedPreferences
import com.example.updatedtrainingapp.dataBase.Constants
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

class Utils {

    companion object {
        fun listToString(list: MutableList<String>): String {
            val stringBuilder = StringBuilder()
            for (i in 0 until list.size) {
                if (list[i] != "") {
                    if (i != list.size - 1)
                        stringBuilder.append("${list[i]} , ")
                    else
                        stringBuilder.append(list[i])
                }
            }
            return stringBuilder.toString()
        }

        fun stringToList(string: String): MutableList<String> {
            return if (string != "")
                string.split(" , ").toMutableList()
            else
                mutableListOf()
        }

        fun getCurrentTime(): String {
            val calendar = Calendar.getInstance()
            val date = calendar.time
            val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.UK)
            return dateFormat.format(date)
        }

        fun getCurrentTrainingList(): String {
            val trainingName = MySharedPreferences.getString(Constants.SAVE_TRAINING_NAME)
            return trainingName + Constants.SAVE_NEW_EXERCISE_LIST
        }
    }
}