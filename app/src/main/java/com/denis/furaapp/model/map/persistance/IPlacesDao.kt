package com.denis.furaapp.model.map.persistance

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.denis.furaapp.model.map.persistance.entity.PlaceDb
import io.reactivex.Flowable

@Dao
interface IPlacesDao {

    @Query("SELECT * from places")
    fun observePlaces(): Flowable<List<PlaceDb>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlaces(places: List<PlaceDb>)
}