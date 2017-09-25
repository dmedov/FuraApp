package com.denis.furaapp.model.map.db

import com.denis.furaapp.model.map.db.entity.PlaceDb
import com.denis.furaapp.model.map.entity.Place
import io.reactivex.Completable
import io.reactivex.Flowable

class PlacesStorage(private val placesDao: PlacesDao) : IPlacesStorage {
    override fun observePlaces(): Flowable<List<Place>> {
        return placesDao.observePlaces().map { it.map { Place(it.id, it.name, it.lat, it.lng, it.categoryId) } }
    }

    override fun addPlaces(places: List<Place>): Completable {
        return Completable.fromAction {
            placesDao.insertPlaces(places.map { PlaceDb(it.id, it.name, it.lat, it.lng, it.categoryId) })
        }
    }
}