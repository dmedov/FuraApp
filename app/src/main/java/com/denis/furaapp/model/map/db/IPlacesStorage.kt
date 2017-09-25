package com.denis.furaapp.model.map.db

import com.denis.furaapp.model.map.entity.Place
import io.reactivex.Completable
import io.reactivex.Flowable

interface IPlacesStorage {
    fun observePlaces(): Flowable<List<Place>>
    fun addPlaces(places: List<Place>): Completable
}