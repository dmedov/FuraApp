package com.denis.furaapp.di.module

import android.arch.persistence.room.Room
import android.content.Context
import com.denis.furaapp.model.map.db.PlacesDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideDatabase() : PlacesDatabase {
        return Room.databaseBuilder(context,
                PlacesDatabase::class.java, "places-bd")
                .build()
    }
}