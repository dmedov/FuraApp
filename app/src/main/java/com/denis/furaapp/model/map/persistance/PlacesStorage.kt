package com.denis.furaapp.model.map.persistance

import com.denis.furaapp.model.map.persistance.entity.PlaceDb
import com.denis.furaapp.model.map.entity.Place
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

class PlacesStorage(private val placesDao: IPlacesDao,
                    private val keyValueStorage: IKeyValueStorage) : IPlacesStorage {
    override fun observePlaces(): Flowable<List<Place>> {
        return placesDao.observePlaces().map { it.map { Place(it.id, it.name, it.lat, it.lng, it.categoryId) } }
    }

    override fun addPlaces(places: List<Place>): Completable {
        return Completable.fromAction {
            placesDao.insertPlaces(places.map { PlaceDb(it.id, it.name, it.lat, it.lng, it.categoryId) })
        }
    }

    override fun latestPlaceId(): Single<Int> {
        return Single.fromCallable {
            keyValueStorage.getInt("latest_downloaded_place_id", 1)
        }
    }

    override fun setLatestPlaceId(id: Int): Completable {
        return Completable.fromAction {
            keyValueStorage.setInt("latest_downloaded_place_id", id)
        }
    }
}