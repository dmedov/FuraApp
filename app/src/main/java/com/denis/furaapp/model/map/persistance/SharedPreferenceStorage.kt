package com.denis.furaapp.model.map.persistance

import android.content.SharedPreferences
import timber.log.Timber


class SharedPreferenceStorage(private val sharedPreferences: SharedPreferences): IKeyValueStorage {

    override fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    override fun setInt(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.commit()
        Timber.d("value($value) for key $key saved")
    }
}