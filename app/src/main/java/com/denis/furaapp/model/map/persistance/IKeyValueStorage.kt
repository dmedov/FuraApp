package com.denis.furaapp.model.map.persistance



interface IKeyValueStorage {
    fun getInt(key: String, defaultValue: Int): Int
    fun setInt(key: String, value: Int)
}