package com.denis.furaapp.model

import com.denis.furaapp.model.map.api.PlacesApi
import com.denis.furaapp.model.map.db.IPlacesStorage
import com.denis.furaapp.model.map.entity.Place
import com.denis.furaapp.model.map.entity.PlacesResponse
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import timber.log.Timber

class PlacesRepository(private val placesApi: PlacesApi,
                       private val placesStorage: IPlacesStorage) : IPlacesRepository {

    private var latest = 1

    override fun fetchPlaces(startId: Int): Observable<PlacesResponse> {
        Timber.i("start fetch places from $startId")
        return placesApi.places(startId, 300)
    }

    override fun latestPlaceId(): Single<Int> {
        return Single.fromCallable { getLatest() }
    }

    private fun getLatest(): Int {
        return latest
    }

    override fun persistPlaces(places: List<Place>): Completable {
        Timber.i("persist places")
        return placesStorage.addPlaces(places)
    }

    override fun setLatestPlaceId(id: Int): Completable {
        Timber.i("set latest place id $id")
        return Completable.fromAction {
            latest = id
        }
    }

    override fun observePlaces(): Flowable<List<Place>> {
        return placesStorage.observePlaces()
    }
}