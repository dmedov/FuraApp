package com.denis.furaapp.model.map.persistance

import com.denis.furaapp.model.map.entity.Place
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

interface IPlacesStorage {
    fun observePlaces(): Flowable<List<Place>>
    fun addPlaces(places: List<Place>): Completable
    fun latestPlaceId(): Single<Int>
    fun setLatestPlaceId(id: Int): Completable
}