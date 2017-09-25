package com.denis.furaapp.model

import com.denis.furaapp.model.map.entity.Place
import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single

interface IPlacesRepository {
    fun fetchPlaces(startId: Int): Observable<PlacesResponse>
    fun persistPlaces(places: List<Place>): Completable
    fun latestPlaceId(): Single<Int>
    fun setLatestPlaceId(id: Int): Completable
    fun observePlaces(): Flowable<List<Place>>
}