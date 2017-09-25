package com.denis.furaapp.model.map.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.denis.furaapp.model.map.db.entity.PlaceDb

@Database(entities = arrayOf(PlaceDb::class),
        version = 1)
abstract class PlacesDatabase : RoomDatabase() {
    abstract fun placesDao(): PlacesDao
}