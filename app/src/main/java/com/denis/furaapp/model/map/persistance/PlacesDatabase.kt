package com.denis.furaapp.model.map.persistance

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.denis.furaapp.model.map.persistance.entity.PlaceDb

@Database(entities = arrayOf(PlaceDb::class),
        version = 1)
abstract class PlacesDatabase : RoomDatabase() {
    abstract fun placesDao(): IPlacesDao
}