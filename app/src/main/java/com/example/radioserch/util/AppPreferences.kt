package com.example.radioserch.util

import android.content.Context
import android.content.SharedPreferences
import com.example.radioserch.util.Constant.Companion.PREFS_NAME
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppPreferences @Inject constructor(context: Context) {

    private val storage = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun savePreference(prefKey: String?, objPrefValue: Any?) {
        val editor: SharedPreferences.Editor = storage.edit()
        when (objPrefValue) {
            is String -> editor.putString(prefKey, objPrefValue as String?)
            is Boolean -> editor.putBoolean(prefKey, (objPrefValue as Boolean?)!!)
            is Int -> editor.putInt(prefKey, (objPrefValue as Int?)!!)
            is Long -> editor.putLong(prefKey, (objPrefValue as Long?)!!)
            is Float -> editor.putFloat(prefKey, (objPrefValue as Float?)!!)
        }
        editor.apply()
    }

    fun retrievePreference(prefKey: String?, objPrefValue: Any): Any? {
        return when (objPrefValue) {
            is String -> storage.getString(prefKey, objPrefValue.toString())
            is Boolean -> storage.getBoolean(prefKey, objPrefValue)
            is Int -> storage.getInt(prefKey, objPrefValue)
            is Long -> storage.getLong(prefKey, objPrefValue)
            is Float -> storage.getFloat(prefKey, objPrefValue)
            else -> objPrefValue
        }
    }

    fun cleanPrefs() {
        storage.edit().clear().apply()
    }
}